public class ValidateBinarySearchTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor to initialize the node with a value
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if the binary tree is a valid Binary Search Tree (BST)
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    // Helper function to validate the BST
    // It checks if the tree satisfies the BST properties within a given range
    private static boolean isValidBST(TreeNode node, Integer min, Integer max) {
        // Base case: if the node is null, it's a valid BST (empty tree is considered valid)
        if (node == null) {
            return true;
        }

        // Check if the current node's value violates the min/max constraints
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Recursively check the left subtree and right subtree with updated constraints
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Example usage

        // Constructing a valid BST:
        //         5
        //        / \
        //       3   7
        //      / \ / \
        //     2  4 6  8

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Check if the tree is a valid BST
        if (isValidBST(root)) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is not a valid BST.");
        }

        // Constructing an invalid BST:
        //         5
        //        / \
        //       3   7
        //      / \ / \
        //     2  4 6  9
        //              \
        //               1 (This node violates the BST property)

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(9);
        root2.right.right.right = new TreeNode(1); // This node violates the BST rule

        // Check if the tree is a valid BST
        if (isValidBST(root2)) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is not a valid BST.");
        }
    }
}
