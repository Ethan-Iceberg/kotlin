import React from 'react';
import { Alert, Button, NativeModules, Text, View } from 'react-native';
import CustomView from './CustomView';



const App = () =>{

  const handleNativeEvent = (event) => {
    const message = event.nativeEvent.customNativeEventMessage;
    Alert.alert('Received Event', message);
  };

  return(
    <><Button
      title="GoToAndroid"
      onPress={() => {
        const { CalendarModule } = NativeModules;
        CalendarModule.createCalendarEvent('testName', 'testLocation');
      } } />
      <CustomView
        style={{ height: 200, width: 200 }}
        message={"Custom Message"}
        onClick={handleNativeEvent} /></>
  )
}

export default App