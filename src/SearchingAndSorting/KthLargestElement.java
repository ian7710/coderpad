package SearchingAndSorting;

import java.util.PriorityQueue;
import java.util.Collections;

public class KthLargestElement {

    // Function to find the k-th largest element in an unsorted array
    public static int findKthLargest(int[] nums, int k) {
        // Create a min heap using PriorityQueue with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Iterate through the array elements
        for (int num : nums) {
            // Add each element to the heap
            minHeap.add(num);

            // If the heap size exceeds k, remove the smallest element
            // This ensures the heap always contains the k largest elements seen so far
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the root, which is the smallest element
            }
        }

        // The root of the heap is now the k-th largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        // Find the k-th largest element
        int kthLargest = findKthLargest(nums, k);

        // Print the result
        System.out.println("The " + k + "-th largest element is: " + kthLargest);
    }
}

