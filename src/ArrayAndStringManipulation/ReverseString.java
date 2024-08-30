package ArrayAndStringManipulation;

public class ReverseString {

    // The main method serves as the entry point for the program
    public static void main(String[] args) {

         // Define character array representing the string "hello"
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        // Call the reverseString method to reverse the array in place
        reverseString(s);

        // Print the reversed array, which should output "olleh"
        System.out.println(s);

    }

    // Method to reverse a character array in place
    public static void reverseString(char[] s) {
        // Initialize two pointers: 'left' starting from the beginning (index 0)
        // and 'right' starting from the end (index s.length - 1) of the array
        int left = 0, right = s.length - 1;

        // Continue swapping characters while the left pointer is less than the right pointer
        while (left < right) {
            // Temporarily store the character at the 'left' pointer
            char temp = s[left];

            // Swap the character at the 'left' pointer with the character at the 'right' pointer
            s[left] = s[right];
            s[right] = temp;

            // Move the 'left'  pointer one position to the right
            left++;

            // Move the 'right' pointer one position to the left
            right--;
        }

        // the loop ends when 'left' is no longer less than 'right',
        // meaning all the characters have been swapped
    }

}
