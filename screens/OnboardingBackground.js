import React, { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, TextInput, FlatList} from 'react-native';
import { Bar } from 'react-native-progress';


export default function OnboardingBackground({navigation}) {
  // Create Input variable and culture list variable
  const [inputText, setInputText] = useState('');
  const [cultureList, setcultureList] = useState([]);

  // Create function to add word to list
  const handleAddWord = () => {
    // Make sure user typed in a word
    if (inputText.trim()){
      setcultureList([...cultureList, inputText.trim()]);
      setInputText('');
    }
  }
  return (
    <View style={styles.container}>
      <Bar progress={0.33} width={300} color="#F28B0C" />
      <Text style={styles.titleText}>What is your background?</Text>
      <Text style={styles.text}>Type in your ethnicity or nationality</Text>
      <TextInput
        style={styles.input}
        placeholder="Enter ethnicity/nationality"
        value={inputText}
        onChangeText={setInputText}
        onSubmitEditing={handleAddWord}
      />
      <FlatList
        data={cultureList}
        keyExtractor={(item, index) => index.toString()}
        renderItem={({ item }) => <Text style={styles.wordItem}>{item}</Text>}
        />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#8A860A',
    justifyContent: 'flex-start',
    padding: 20,
    paddingTop: 70
  },
  titleText: {
    color: '#fff',
    fontSize: 50,
    paddingTop: 30
  },
  text: {
    color: '#fff',
    fontSize: 20
  }
});
