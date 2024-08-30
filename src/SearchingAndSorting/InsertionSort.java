package SearchingAndSorting;

public class InsertionSort {

    // Function to perform Insertion Sort on an array
    public static void insertionSort(int[] arr) {
        // Traverse the array from the second element to the end
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // The element to be inserted in the sorted part of the array
            int j = i - 1; // The last element of the sorted part of the array

            // Move elements of arr[0..i-1] that are greater than the key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift the element one position to the right
                j--; // Move the index one position to the left
            }

            // Insert the key at its correct position in the sorted part of the array
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Perform Insertion Sort on the array
        insertionSort(arr);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

