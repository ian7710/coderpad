package StacksAndQueues;

import java.util.Stack;

public class BalancedParentheses {

    // Function to check if the given expression has balanced parentheses
    public static boolean isBalanced(String expression) {
        // Stack to store opening parentheses
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If the character is a closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty, it means there is no corresponding opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element from the stack
                char top = stack.pop();

                // Check if the popped element matches the corresponding opening bracket
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty, all parentheses were balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Example expressions
        String expression1 = "{[()]}";
        String expression2 = "{[(])}";
        String expression3 = "{{[[(())]]}}";

        // Check if the expressions are balanced
        System.out.println("Expression: " + expression1 + " is balanced: " + isBalanced(expression1)); // true
        System.out.println("Expression: " + expression2 + " is balanced: " + isBalanced(expression2)); // false
        System.out.println("Expression: " + expression3 + " is balanced: " + isBalanced(expression3)); // true
    }
}

