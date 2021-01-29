import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:quiz/models/quiz_session.dart';
import 'package:quiz/widgets/question_screen.dart';

class GameScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ChangeNotifierProvider(
        create: (_) => QuizSession(),
        child: Consumer<QuizSession>(
          builder: (consumerContext, session, __) =>
              QuestionScreen(consumerContext),
        ),
      ),
    );
  }
}
