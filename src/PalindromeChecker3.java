public class PalindromeChecker3 {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        // While left pointer is less than right pointer, compare characters
        while (left < right) {
            // If characters at left and right pointers don't match, return false
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;  // Move left pointer to the right
            right--; // Move right pointer to the left (this was wrong in your code)
        }
        // If all characters match, return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));  // Output: true
        System.out.println(isPalindrome("hello"));  // Output: false
    }
}
