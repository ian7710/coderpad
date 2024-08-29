public class PalindromeChecker2 {

    // Method to  check if a given sting is a palindrome
    public static boolean isPalindrome(String s) {
        // Initialize two pointers: 'left' starting at the beginning of the string
        // and 'right' starting at the end of the string
        int left = 0, right = s.length() -1;

        // Continue looping while the left pointer is less than the right pointer
        while (left < right) {
            // If characters at the current positions of 'left' and 'right' pointers are not equal,
            // then the string is not a palindrome, so return false
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // move the 'left' pointer one step to the right
            left++;
            // Move the 'right' pointer one step to the left
            right--;
        }

        // If the loop completes without  finding a mismatch, the string is a palindrome, so return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("hello"));
    }

}
