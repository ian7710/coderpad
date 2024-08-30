package ArrayAndStringManipulation;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    // Function to find the first non-repeating character in a string
    public static char findFirstNonRepeatingChar(String str) {
        // Create a HashMap to store the frequency of each character
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Traverse the string and fill the HashMap with character frequencies
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // If the character is already in the map, increment its count
            if (charCountMap.containsKey(currentChar)) {
                charCountMap.put(currentChar, charCountMap.get(currentChar) + 1);
            } else {
                // If the character is not in the map, add it with a count of 1
                charCountMap.put(currentChar, 1);
            }
        }

        // Traverse the string again to find the first character with a count of 1
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charCountMap.get(currentChar) == 1) {
                return currentChar; // Return the first non-repeating character
            }
        }

        // If no non-repeating character is found, return a special value (e.g., '\0')
        return '\0';
    }

    public static void main(String[] args) {
        // Example usage
        String str = "swiss";
        char result = findFirstNonRepeatingChar(str);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("There is no non-repeating character in the string.");
        }
    }
}
