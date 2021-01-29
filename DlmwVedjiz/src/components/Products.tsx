import React, {useEffect, useState} from "react";
import { createStackNavigator } from "@react-navigation/stack";
import ProductList from "./ProductList";
import Product from "./Product";

export default function Products() {

  const Stack = createStackNavigator();

  return (
    <Stack.Navigator>
      <Stack.Screen name="Products" component={ProductList}/>
      <Stack.Screen name="Detail" component={Product}/>
    </Stack.Navigator>
  );
}