package StacksAndQueues;

import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {

    // Function to find the next greater element for each element in the array
    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Array to store the result
        Stack<Integer> stack = new Stack<>(); // Stack to store the indices of elements

        // Initialize the result array with -1, assuming there is no greater element
        Arrays.fill(result, -1);

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while the stack is not empty and the top of the stack is less than or equal to arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // If the stack is not empty, the top of the stack is the next greater element for arr[i]
            if (!stack.isEmpty()) {
                result[i] = arr[stack.peek()];
            }

            // Push the current element's index onto the stack
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {4, 5, 2, 10, 8};

        // Find the next greater elements
        int[] result = findNextGreaterElements(arr);

        // Print the result
        System.out.println("Next greater elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }
}

