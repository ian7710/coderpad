package SearchingAndSorting;

public class BinarySearch {

    // Function to perform binary search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;              // Start index of the search range
        int right = arr.length - 1; // End index of the search range

        // While there is a valid search range
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // Check if the target is at the middle index
            if (arr[mid] == target) {
                return mid; // Target found, return its index
            }

            // If the target is smaller than the mid element, search the left half
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                // If the target is larger than the mid element, search the right half
                left = mid + 1;
            }
        }

        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Example usage

        // Sorted array to search in
        int[] arr = {2, 3, 4, 10, 40};

        // Target value to find
        int target = 10;

        // Perform binary search
        int result = binarySearch(arr, target);

        // Print the result
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

