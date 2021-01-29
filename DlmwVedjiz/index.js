/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName, apiBaseUrl} from './app.json';
import axios from 'axios';

axios.defaults.baseURL = apiBaseUrl;
AppRegistry.registerComponent(appName, () => App);
