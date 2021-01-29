import React, { useEffect } from 'react';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Profile from './Profile';
import Products from './Products';
import Basket from './Basket';
import { UserContainer, ProductContainer } from '../services';
import Stock from './Stock';

export default function Navbar() {

  const Tab = createBottomTabNavigator();
  const userContainer = UserContainer.useContainer();
  const productContainer = ProductContainer.useContainer();

  useEffect(() => {
    userContainer.refreshToken();
    productContainer.getProducts();
    userContainer.getUserInfo(userContainer.token as string);
  }, [userContainer])

  return (
    <Tab.Navigator initialRouteName="Products">
      <Tab.Screen name="Products" component={Products} />
      <Tab.Screen name="Basket" component={Basket} />
      {userContainer.user?.user_type == 1 && <Tab.Screen name="Stock" component={Stock} />}
      <Tab.Screen name="Profile" component={Profile} />
    </Tab.Navigator>
  );
}