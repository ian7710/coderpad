package ArrayAndStringManipulation;

public class RemoveDuplicatesFromSortedArray {

    // Function to remove duplicates from a sorted array
    public static int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Initialize a pointer to track the position of the unique elements
        int uniqueIndex = 0;

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous unique element
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;          // Move the unique index pointer forward
                nums[uniqueIndex] = nums[i];  // Update the array at uniqueIndex with the current element
            }
        }

        // The new length of the array without duplicates is uniqueIndex + 1
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};

        // Call the removeDuplicates function
        int newLength = removeDuplicates(nums);

        // Print the result
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

