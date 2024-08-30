package SearchingAndSorting;

public class SearchInRotatedArray {

    // Function to search for a target in a rotated sorted array
    public static int search(int[] nums, int target) {
        int left = 0;               // Start index of the search range
        int right = nums.length - 1; // End index of the search range

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If the target is found at mid, return the index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // If the target lies in the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Discard the right half
                } else {
                    left = mid + 1;  // Discard the left half
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // If the target lies in the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Discard the left half
                } else {
                    right = mid - 1; // Discard the right half
                }
            }
        }

        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Example usage

        // Rotated sorted array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // Target to search for
        int target = 0;

        // Perform the search
        int result = search(nums, target);

        // Print the result
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found.");
        }
    }
}

