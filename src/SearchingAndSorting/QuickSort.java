package SearchingAndSorting;

public class QuickSort {

    // Function to perform QuickSort on an array
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the elements before and after the pivot
            quickSort(arr, low, pivotIndex - 1);  // Sort the left subarray
            quickSort(arr, pivotIndex + 1, high); // Sort the right subarray
        }
    }

    // Helper function to partition the array
    private static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = arr[high];

        // Pointer for the greater element
        int i = low - 1;

        // Traverse through all elements
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++; // Move the pointer for greater element
                // Swap the current element with the element at pointer i
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the element at pointer i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the index of the pivot element
        return i + 1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {10, 7, 8, 9, 1, 5};

        // Perform QuickSort on the entire array
        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
