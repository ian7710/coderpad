package TreesAndGraphs;

public class CheckBalancedBinaryTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val; // Value of the node
        TreeNode left; // Reference to the left child
        TreeNode right; // Reference to the right child

        // Constructor to create a new node
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if the binary tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper function to check the height of the tree
    // Returns the height of the tree if balanced, otherwise returns -1
    private static int checkHeight(TreeNode node) {
        // Base case: if the node is null, its height is 0
        if (node == null) {
            return 0;
        }

        // Recursively check the height of the left subtree
        int leftHeight = checkHeight(node.left);
        // If the left subtree is not balanced, return -1
        if (leftHeight == -1) {
            return -1;
        }

        // Recursively check the height of the right subtree
        int rightHeight = checkHeight(node.right);
        // If the right subtree is not balanced, return -1
        if (rightHeight == -1) {
            return -1;
        }

        // If the difference in heights is greater than 1, the tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Example usage

        // Create a balanced binary tree
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Check if the binary tree is balanced
        System.out.println("Is the binary tree balanced? " + isBalanced(root)); // Should print true

        // Create an unbalanced binary tree
        //         1
        //        /
        //       2
        //      /
        //     3

        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.left = new TreeNode(2);
        unbalancedRoot.left.left = new TreeNode(3);

        // Check if the binary tree is balanced
        System.out.println("Is the binary tree balanced? " + isBalanced(unbalancedRoot)); // Should print false
    }
}

