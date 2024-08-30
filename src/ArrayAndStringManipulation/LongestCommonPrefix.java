package ArrayAndStringManipulation;

public class LongestCommonPrefix {

    // Function to find the longest common prefix among an array of strings
    public static String findLongestCommonPrefix(String[] strs) {
        // Edge case: If the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize the prefix as the first string in the array
        String prefix = strs[0];

        // Loop through the rest of the strings in the array
        for (int i = 1; i < strs.length; i++) {
            // Compare the current prefix with each string
            // Reduce the prefix length until it matches the start of the string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, return an empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the longest common prefix found
        return prefix;
    }

    public static void main(String[] args) {
        // Example usage
        String[] strs = {"flower", "flow", "flight"};

        // Call the function to find the longest common prefix
        String result = findLongestCommonPrefix(strs);

        // Print the result
        System.out.println("The longest common prefix is: " + result);
    }
}
