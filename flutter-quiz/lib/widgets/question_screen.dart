import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:quiz/models/question.dart';
import 'package:quiz/models/quiz_session.dart';

class QuestionScreen extends StatelessWidget {
  QuestionScreen(BuildContext context);

  Widget getScreenToShow(BuildContext buildContext, QuizSession quizSession) {
    if (quizSession.hasCompletedAllQuestions()) {
      return Scaffold(
        body: Column(
          children: [
            Text("Your score is ${quizSession.score}"),
            ElevatedButton(
                onPressed: () {
                  var session =
                      Provider.of<QuizSession>(buildContext, listen: false);
                  session.resetSession();
                },
                child: SizedBox(
                    width: double.infinity,
                    child: Text("New game",
                        textScaleFactor: 2.0, textAlign: TextAlign.center))),
          ],
        ),
      );
    }
    return buildQuestion(buildContext, quizSession.currentQuestion);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ChangeNotifierProvider(
        create: (_) => QuizSession(),
        child: Consumer<QuizSession>(
          builder: (consumerContext, session, __) =>
              getScreenToShow(consumerContext, session),
        ),
      ),
    );
  }

  Widget buildQuestion(BuildContext context, Question question) {
    var answerButtons = question.answers.map((answer) {
      return ElevatedButton(
          onPressed: () {
            var session = Provider.of<QuizSession>(context, listen: false);
            if (session.checkAnswer(answer)) {
              session.nextQuestion();
            }
          },
          child: SizedBox(
              width: double.infinity,
              child: Text(answer,
                  textScaleFactor: 2.0, textAlign: TextAlign.center)));
    });

    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Row(
            children: [
              Text(question.caption, textScaleFactor: 2.0),
              buildTooltipButton(context, question),
            ],
            mainAxisAlignment: MainAxisAlignment.center,
          ),
          ...answerButtons,
        ],
      ),
    );
  }

  ElevatedButton buildTooltipButton(
      BuildContext buildContext, Question question) {
    return ElevatedButton(
      onPressed: () {
        showDialog(
          context: buildContext,
          barrierDismissible: false,
          builder: (BuildContext context) {
            return AlertDialog(
              title: Text("Hint"),
              content: SingleChildScrollView(
                child: ListBody(
                  children: <Widget>[
                    Text(question.hint),
                  ],
                ),
              ),
              actions: <Widget>[
                TextButton(
                  child: Text("Ok"),
                  onPressed: () {
                    Navigator.of(context).pop();
                  },
                ),
              ],
            );
          },
        );
      },
      child: Text("Hint"),
    );
  }
}
