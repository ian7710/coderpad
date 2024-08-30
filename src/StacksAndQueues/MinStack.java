package StacksAndQueues;

import java.util.Stack;

public class MinStack {

    // Stack to store all the elements
    private Stack<Integer> stack;

    // Stack to store the minimum values
    private Stack<Integer> minStack;

    // Constructor to initialize the stacks
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push method to add an element to the stack
    public void push(int x) {
        // Push the element onto the main stack
        stack.push(x);

        // Push the element onto the minStack if it is the smallest element seen so far
        // If minStack is empty or x is less than or equal to the current minimum, push x onto minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Pop method to remove the top element from the stack
    public void pop() {
        // If the top element of the main stack is equal to the top element of the minStack,
        // pop the top element from both stacks
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        // Pop the top element from the main stack
        stack.pop();
    }

    // Top method to get the top element of the stack
    public int top() {
        return stack.peek();
    }

    // Min method to get the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        // Example usage
        MinStack minStack = new MinStack();

        // Push elements onto the stack
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        // Get the minimum element
        System.out.println("Current minimum: " + minStack.getMin()); // Should print 0

        // Pop the top element
        minStack.pop();

        // Get the minimum element after the pop
        System.out.println("Current minimum: " + minStack.getMin()); // Should print 0

        // Pop the top element again
        minStack.pop();

        // Get the minimum element after the pop
        System.out.println("Current minimum: " + minStack.getMin()); // Should print 0

        // Pop the top element again
        minStack.pop();

        // Get the minimum element after the pop
        System.out.println("Current minimum: " + minStack.getMin()); // Should print 2
    }
}
