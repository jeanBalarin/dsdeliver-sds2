import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { View } from 'react-native';
import Header from './src/Header';
import { useFonts, OpenSans_400Regular, OpenSans_700Bold } from '@expo-google-fonts/open-sans';
import AppLoading from 'expo-app-loading';
import Home from './src/Home';


export default function App() { 

    let [fontsLoaded] = useFonts({
      OpenSans_400Regular,
      OpenSans_700Bold
    });
  
    if (!fontsLoaded) {
      return <AppLoading />;
    }

  return (
    <View>
      <Header />
      <Home />
    </View>
  );
}
