package ArrayAndStringManipulation;

public class RotateArray {

    // Function to rotate an array to the right by k steps
    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        // Handle cases where k is greater than the length of the array
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper function to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // Rotate the array to the right by k steps
        rotate(nums, k);

        // Print the rotated array
        System.out.println("Array after rotating by " + k + " steps:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

