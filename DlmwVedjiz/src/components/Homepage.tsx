import React from "react";
import { View } from "react-native";
import Login from "./Login";
import Register from "./Register";

export default function Homepage() {

  return (
    <View>
      <Register/>
      <Login/>
    </View>
  );
}