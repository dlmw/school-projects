import { useState } from "react";
import AsyncStorage from "@react-native-community/async-storage";
import axios from "axios";
import { User } from "src/models/User";
import { GetUserInfoResponse } from "src/models/Request";

const TOKEN_KEY = "@TOKEN";

export const useUserContainer = () => {
  const [token, setToken] = useState<string>();
  const [user, setUser] = useState<User>();

  const login = async (value: string) => {
    try {
      await AsyncStorage.setItem(TOKEN_KEY, value)
      setToken(value);
    } catch(e) {
      // save error
    }
  }

  const refreshToken = async () => {
    let token = await AsyncStorage.getItem(TOKEN_KEY);

    setToken(token ? token : undefined);
  }

  const getUserInfo = async (token: string) => {
    axios.get("api/me", {
      headers: {
        Authorization: "Bearer " + token
      }
    })
    .then(function (response: GetUserInfoResponse) {
      setUser(response.data.data);
    })
    .catch(function (error: any) {
          
    });
  }

  return {token, login, refreshToken, getUserInfo, user};
}