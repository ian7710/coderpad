public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 10, 40};
        int target = 10;

        int result = binarySearch(array, target, 0, array.length - 1);
        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, right);
            }

            // If target is smaller, ignore right half
            return binarySearch(arr, target, left, mid - 1);
        }

        // Target was not present in the array
        return -1;
    }
}
