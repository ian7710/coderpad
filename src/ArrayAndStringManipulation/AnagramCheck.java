package ArrayAndStringManipulation;

import java.util.Arrays;

public class AnagramCheck {

    // Function to check if two strings are anagrams of each other
    public static boolean areAnagrams(String str1, String str2) {
        // Step 1: Check if the lengths of the strings are equal
        if (str1.length() != str2.length()) {
            return false; // If lengths are not equal, they cannot be anagrams
        }

        // Step 2: Convert both strings to character arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Step 3: Sort the character arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Step 4: Compare the sorted character arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        // Example usage

        String str1 = "listen";
        String str2 = "silent";

        // Check if the strings are anagrams
        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }

        String str3 = "triangle";
        String str4 = "integral";

        // Check if the strings are anagrams
        if (areAnagrams(str3, str4)) {
            System.out.println(str3 + " and " + str4 + " are anagrams.");
        } else {
            System.out.println(str3 + " and " + str4 + " are not anagrams.");
        }

        String str5 = "apple";
        String str6 = "pale";

        // Check if the strings are anagrams
        if (areAnagrams(str5, str6)) {
            System.out.println(str5 + " and " + str6 + " are anagrams.");
        } else {
            System.out.println(str5 + " and " + str6 + " are not anagrams.");
        }
    }
}

