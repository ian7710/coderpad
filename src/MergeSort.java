public class MergeSort {

    // This method implements the merge sort algorithm.
    // It recursively divides the array into two halves, sorts them, and then merges them.
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point to divide the array into two halves
            int mid = (left + right) / 2;

            // Recursively sort the first half
            mergeSort(arr, left, mid);

            // Recursively sort the second half
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // This method merges two subarrays of arr[].
    // The first subarray is arr[left..mid]
    // The second subarray is arr[mid+1..right]
    private static void merge(int[] arr, int left, int mid, int right) {
        // Determine the size of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the two subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy the data to the temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        // Initialize indices for the subarrays and the merged array
        int i = 0, j = 0;
        int k = left; // Initial index of the merged subarray

        // Merge the temporary arrays back into arr[left..right]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]; // If the element in the left subarray is smaller, add it to the merged array
                i++;
            } else {
                arr[k] = R[j]; // If the element in the right subarray is smaller, add it to the merged array
                j++;
            }
            k++; // Move to the next position in the merged array
        }

        // Copy any remaining elements of L[] (if any)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of R[] (if any)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        // Call the mergeSort function
        mergeSort(arr, 0, n - 1);

        // Print the sorted array
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
