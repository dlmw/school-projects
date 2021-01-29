import 'package:flutter/material.dart';
import 'package:quiz/widgets/game_screen.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Quiz"),
      ),
      body: GameScreen(),
    );
  }
}
