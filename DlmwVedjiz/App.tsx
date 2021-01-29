/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import 'react-native-gesture-handler';
import React from 'react';
import {
  StyleSheet,
} from 'react-native';

import {
  Colors,
} from 'react-native/Libraries/NewAppScreen';

import Router from "./src/Router";
import { ThemeProvider } from 'react-native-elements';
import { createStackNavigator } from '@react-navigation/stack';
import { UserContainer, ProductContainer, BasketContainer } from './src/services';

const Stack = createStackNavigator();

declare const global: { HermesInternal: null | {} };

const App = () => {
  return (
    <UserContainer.Provider>
      <ProductContainer.Provider>
        <BasketContainer.Provider>
          <ThemeProvider>
            <Router></Router>
          </ThemeProvider>
        </BasketContainer.Provider>
      </ProductContainer.Provider>
    </UserContainer.Provider>
  )
};

const styles = StyleSheet.create({
  scrollView: {
    backgroundColor: Colors.lighter,
  },
  engine: {
    position: 'absolute',
    right: 0,
  },
  body: {
    backgroundColor: Colors.white,
  },
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
    color: Colors.black,
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
    color: Colors.dark,
  },
  highlight: {
    fontWeight: '700',
  },
  footer: {
    color: Colors.dark,
    fontSize: 12,
    fontWeight: '600',
    padding: 4,
    paddingRight: 12,
    textAlign: 'right',
  },
});

export default App;
