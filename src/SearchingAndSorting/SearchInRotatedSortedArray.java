package SearchingAndSorting;

public class SearchInRotatedSortedArray {

    // Function to search for a target in a rotated sorted array
    public static int search(int[] nums, int target) {
        int left = 0;  // Start index of the search range
        int right = nums.length - 1;  // End index of the search range

        // Binary search logic
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate the middle index

            // Check if the target is at the middle index
            if (nums[mid] == target) {
                return mid;  // Target found, return its index
            }

            // Determine which half is properly sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is in the left half
                    right = mid - 1;
                } else {
                    // Target is in the right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is in the right half
                    left = mid + 1;
                } else {
                    // Target is in the left half
                    right = mid - 1;
                }
            }
        }

        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        // Perform the search
        int result = search(nums, target);

        // Print the result
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}

