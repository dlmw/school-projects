import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { UserContainer } from './services';
import Homepage from './components/Homepage';
import Navbar from './components/Navbar';

export default function Router() {

  const userContainer = UserContainer.useContainer();

  let homePage;

  userContainer.refreshToken();
  // console.log(userContainer.user?.user_type);
  if (userContainer.token) {
    homePage = <Navbar></Navbar>
  } else {
    homePage = <Homepage></Homepage>
  }

  return (
    <NavigationContainer>
      {homePage}
    </NavigationContainer>
  );
}