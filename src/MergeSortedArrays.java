import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        int[] mergedArray = mergeSortedArrays(array1, array2);
        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] mergedArray = new int[length1 + length2];

        int i = 0, j = 0, k = 0;

        // Traverse both arrays and merge them into the mergedArray
        while (i < length1 && j < length2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // If there are remaining elements in arr1
        while (i < length1) {
            mergedArray[k++] = arr1[i++];
        }

        // If there are remaining elements in arr2
        while (j < length2) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
}
