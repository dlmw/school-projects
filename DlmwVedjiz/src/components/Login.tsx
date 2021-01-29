import React from "react";
import { View, ToastAndroid } from "react-native";
import { Formik } from "formik";
import { Button, Input, Text } from "react-native-elements";
import { UserContainer } from "../services";
import * as yup from 'yup';
import { LoginRequest, LoginResponse } from "src/models/Request";

export default function Login() {

  const axios = require("axios");

  const userContainer = UserContainer.useContainer();

  async function onLogin(values: LoginRequest) {
    axios.get("api/me", {
      headers: {
        Authorization: "Bearer " + values.token
      }
    })
      .then(function (response: LoginResponse) {
        userContainer.login(values.token);
      })
      .catch(function (error: any) {
        ToastAndroid.show("Token invalide", ToastAndroid.SHORT);
      });
  }

  return (
    <View>
      <Formik
        initialValues={{ token: "E4R2Vjn2lbf0dby9Uz8383XsE6sqMhItnfsrSxx2SMEbHCnveTAgZOoSIq4E" }}
        onSubmit={values => onLogin(values)}
        validationSchema={
          yup.object().shape({
            token: yup
              .string()
              .min(60, "Token invalide.")
              .required("Le token est requis."),
         })}
      >
        {({ handleChange, handleBlur, handleSubmit, values, errors }) => (
          <View>
            <Input
              onChangeText={handleChange("token")}
              onBlur={handleBlur("token")}
              value={values.token}
              placeholder="Token"
              style={{ marginBottom: 50 }}
            />
            {errors.token &&
              <Text style={{ fontSize: 10, color: 'red' }}>{errors.token}</Text>
            }
            <Button onPress={handleSubmit} title="Connexion" />
          </View>
        )}
      </Formik>
    </View>
  );
}