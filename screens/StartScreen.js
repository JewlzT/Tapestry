import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button} from 'react-native';

export default function StartScreen({navigation}) {
  return (
    <View style={styles.container}>
      <Text style={styles.titleText}>Almost there...</Text>
      <Text style={styles.text}>Help us get to know you better so we can connect you more deeply with your roots.</Text>
      <Button
        title="Continue"
        onPress={() => navigation.navigate('Onboarding1')}
      />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#D9411E',
    justifyContent: 'flex-end',
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
