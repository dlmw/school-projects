import React, {useState, useEffect} from 'react';
import { View, Text } from 'react-native';
import AsyncStorage from "@react-native-community/async-storage";
import { UserContainer } from '../services';
import { Button } from "react-native-elements";

export default function Profile() {

  const userContainer = UserContainer.useContainer();

  let clearAsyncStorage = async () => {
    AsyncStorage.clear();
    userContainer.refreshToken();
  };

  useEffect(() => {
    if(userContainer.token) {
      userContainer.getUserInfo(userContainer.token);
    }
  }, [userContainer.token])

  return (
    <View>
      <Text>{ userContainer.user?.firstname }</Text>
      <Button
       onPress={ clearAsyncStorage }
       title="CLEAR STORAGE /!\">
      </Button>
    </View>
  );
}