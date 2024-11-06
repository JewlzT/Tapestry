import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';


export default function OnboardingBackground({navigation}) {
  return (
    <View style={styles.container}>
      <Text style={styles.titleText}>What is your background?</Text>
      <Text style={styles.text}>Help us get to know you better so we can connect you more deeply with your roots.</Text>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#8A860A',
    justifyContent: 'flex-start',
    padding: 20
  },
  titleText: {
    color: '#fff',
    fontSize: 50
  },
  text: {
    color: '#fff',
    fontSize: 20
  }
});
