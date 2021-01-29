import React from "react";
import { View, ToastAndroid } from "react-native";
import { Formik } from "formik";
import { Button, Input, Text } from "react-native-elements";
import * as yup from 'yup';
import { RegisterRequest } from "src/models/Request";

export default function Register() {

  const axios = require("axios");

  async function onRegister(values: RegisterRequest) {
    axios.post("api/user/apply", {
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
        Accept: "application/json"
      },
      firstname: values.firstname,
      lastname: values.lastname,
      phonenumber: values.phonenumber
    })
      .then(function (response: any) {
        ToastAndroid.show("Vous avez bien été inscrit. Vous recevrez votre token de connexion prochainement.", ToastAndroid.LONG);
      })
      .catch(function (error: any) {
        ToastAndroid.show("Erreur lors de la tentative d'inscription. Ce compte existe peut-être déjà.", ToastAndroid.SHORT);
      });
  }

  return (
    <View>
      <Formik
        initialValues={{ firstname: "Dylan", lastname: "Migewant", phonenumber: "+41 79 1234567" }}
        onSubmit={values => onRegister(values)}
        validationSchema={
          yup.object().shape({
            firstname: yup
              .string()
              .min(2, "Votre prénom doit faire plus de 2 caractères.")
              .required("Votre prénom est requis."),
            lastname: yup
              .string()
              .min(2, "Votre nom doit faire plus de 2 caractères.")
              .required("Votre nom est requis."),
            phonenumber: yup
              .string()
              .min(9)
              .required("Le numéro de téléphone est requis.")
         })}
      >
        {({ handleChange, handleBlur, handleSubmit, values, errors }) => (
          <View>
            <Input
              onChangeText={handleChange("firstname")}
              onBlur={handleBlur("firstname")}
              value={values.firstname}
              placeholder="Prénom"
              textContentType="givenName"
              style={{ marginBottom: 50 }}
            />
            {errors.firstname &&
              <Text style={{ fontSize: 10, color: 'red' }}>{errors.firstname}</Text>
            }
            <Input
              onChangeText={handleChange("lastname")}
              onBlur={handleBlur("lastname")}
              value={values.lastname}
              placeholder="Nom"
              textContentType="familyName"
              style={{ marginBottom: 50 }}
            />
            {errors.lastname &&
              <Text style={{ fontSize: 10, color: 'red' }}>{errors.lastname}</Text>
            }
            <Input
              onChangeText={handleChange("phonenumber")}
              onBlur={handleBlur("phonenumber")}
              value={values.phonenumber}
              placeholder="Numéro de téléphone"
              textContentType="telephoneNumber"
              keyboardType="phone-pad"
              style={{ marginBottom: 50 }}
            />
            {errors.phonenumber &&
              <Text style={{ fontSize: 10, color: 'red' }}>{errors.phonenumber}</Text>
            }
            <Button onPress={handleSubmit} title="Enregistrement" />
          </View>
        )}
      </Formik>
    </View>
  );
}