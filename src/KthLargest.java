import java.util.PriorityQueue;

public class KthLargest {

    // Min-Heap to store the K largest elements
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    // Constructor to initialize the heap and set the value of K
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        // Add initial numbers to the heap
        for (int num : nums) {
            add(num);
        }
    }

    // Method to add a new number to the stream
    public int add(int val) {
        // Add the new value to the min-heap
        minHeap.offer(val);

        // If the heap size exceeds K, remove the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // The root of the heap is the Kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // Example usage:
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        // Create a KthLargest object with k = 3
        KthLargest kthLargest = new KthLargest(k, nums);

        // Add elements to the stream and get the Kth largest element
        System.out.println(kthLargest.add(3));  // Output: 4
        System.out.println(kthLargest.add(5));  // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9));  // Output: 8
        System.out.println(kthLargest.add(4));  // Output: 8
    }
}
