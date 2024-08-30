package StacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks {

    // Two stacks to implement the queue
    private Stack<Integer> stack1; // Stack used for enqueue operation
    private Stack<Integer> stack2; // Stack used for dequeue operation

    // Constructor to initialize the stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to add an element to the queue (enqueue operation)
    public void enqueue(int x) {
        // Push the element onto stack1
        stack1.push(x);
    }

    // Method to remove and return the front element from the queue (dequeue operation)
    public int dequeue() {
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, it means the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Pop and return the top element from stack2
        return stack2.pop();
    }

    // Method to get the front element of the queue without removing it (peek operation)
    public int peek() {
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, it means the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Return the top element from stack2 without popping it
        return stack2.peek();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        // The queue is empty only if both stacks are empty
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        // Example usage
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue and print elements
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 1
        System.out.println("Front element: " + queue.peek()); // Should print 2
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 2

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Should print false

        // Dequeue the remaining element
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 3

        // Check if the queue is empty again
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Should print true
    }
}
