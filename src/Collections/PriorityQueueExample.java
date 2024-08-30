package Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue of Integers
        Queue<Integer> pq = new PriorityQueue<>();

        // Add elements to the PriorityQueue
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        // Access and remove the smallest element (priority element)
        System.out.println("Smallest element: " + pq.poll());

        // Iterate over the PriorityQueue
        for (int number : pq) {
            System.out.println(number);
        }

        // Check if the PriorityQueue contains a specific element
        if (pq.contains(30)) {
            System.out.println("30 is in the queue.");
        }

        // Get the size of the PriorityQueue
        System.out.println("Number of elements: " + pq.size());
    }
}

