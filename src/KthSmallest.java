import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {

    // Max-Heap to store the K smallest elements
    private final PriorityQueue<Integer> maxHeap;
    private final int k;

    // Constructor to initialize the heap and set the value of K
    public KthSmallest(int k, int[] nums) {
        this.k = k;
        this.maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        // Add initial numbers to the heap
        for (int num : nums) {
            add(num);
        }
    }

    // Method to add a new number to the stream
    public int add(int val) {
        // Add the new value to the max-heap
        maxHeap.offer(val);

        // If the heap size exceeds K, remove the largest element
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }

        // The root of the heap is the Kth smallest element
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        // Example usage:
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        // Create a KthSmallest object with k = 3
        KthSmallest kthSmallest = new KthSmallest(k, nums);

        // Add elements to the stream and get the Kth smallest element
        System.out.println(kthSmallest.add(3));  // Output: 4
        System.out.println(kthSmallest.add(5));  // Output: 5
        System.out.println(kthSmallest.add(10)); // Output: 5
        System.out.println(kthSmallest.add(9));  // Output: 8
        System.out.println(kthSmallest.add(4));  // Output: 8
    }
}
