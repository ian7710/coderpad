package ArrayAndStringManipulation;

import java.util.Arrays;

public class MergeSortedArrays {

    // Function to merge two sorted arrays into one sorted array
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length; // Length of the first array
        int n2 = arr2.length; // Length of the second array
        int[] mergedArray = new int[n1 + n2]; // Array to hold the merged result

        int i = 0, j = 0, k = 0; // Pointers for arr1, arr2, and mergedArray

        // Traverse both arrays and merge them in sorted order
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++]; // Add the smaller element to the merged array
            } else {
                mergedArray[k++] = arr2[j++]; // Add the smaller element to the merged array
            }
        }

        // Copy the remaining elements of arr1, if any
        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }

        // Copy the remaining elements of arr2, if any
        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray; // Return the merged array
    }

    public static void main(String[] args) {
        // Example usage

        int[] arr1 = {1, 3, 5, 7}; // First sorted array
        int[] arr2 = {2, 4, 6, 8}; // Second sorted array

        // Merge the two sorted arrays
        int[] mergedArray = mergeSortedArrays(arr1, arr2);

        // Print the merged sorted array
        System.out.println("Merged Sorted Array: " + Arrays.toString(mergedArray));
    }
}

