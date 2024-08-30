package TreesAndGraphs;

public class ValidateBST {

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

    // Function to check if the binary tree is a valid BST
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to validate the BST
    // The function uses a range [min, max] to validate the node values
    private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
        // Base case: if the node is null, return true (an empty tree is a valid BST)
        if (node == null) {
            return true;
        }

        // Check if the current node's value is within the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively validate the left and right subtrees
        // For the left subtree, the max value is updated to node.val
        // For the right subtree, the min value is updated to node.val
        return isValidBSTHelper(node.left, min, node.val) &&
                isValidBSTHelper(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Example usage

        // Create a valid BST
        //        5
        //       / \
        //      3   7
        //     / \ / \
        //    2  4 6  8

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Check if the tree is a valid BST
        System.out.println("Is the binary tree a valid BST? " + isValidBST(root)); // Should print true

        // Create an invalid BST
        //        5
        //       / \
        //      3   7
        //     / \ / \
        //    2  6 4  8

        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(3);
        invalidRoot.right = new TreeNode(7);
        invalidRoot.left.left = new TreeNode(2);
        invalidRoot.left.right = new TreeNode(6); // Invalid: 6 is greater than 5 and should not be in the left subtree
        invalidRoot.right.left = new TreeNode(4); // Invalid: 4 is less than 7 and should not be in the right subtree
        invalidRoot.right.right = new TreeNode(8);

        // Check if the tree is a valid BST
        System.out.println("Is the binary tree a valid BST? " + isValidBST(invalidRoot)); // Should print false
    }
}

