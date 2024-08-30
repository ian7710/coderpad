package TreesAndGraphs;

public class LowestCommonAncestor {

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

    // Function to find the Lowest Common Ancestor (LCA) of two nodes in the binary tree
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or if we find either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for the left and right subtrees
        TreeNode leftLCA = findLCA(root.left, p, q);
        TreeNode rightLCA = findLCA(root.right, p, q);

        // If both the left and right subtrees return non-null, this node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, if one of the subtrees returns a non-null, return that result
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        // Example usage

        // Create a binary tree
        //        3
        //       / \
        //      5   1
        //     / \ / \
        //    6  2 0  8
        //      / \
        //     7   4

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Find the LCA of nodes 5 and 1
        TreeNode lca = findLCA(root, root.left, root.right);
        System.out.println("LCA of 5 and 1: " + lca.val); // Should print 3

        // Find the LCA of nodes 5 and 4
        lca = findLCA(root, root.left, root.left.right.right);
        System.out.println("LCA of 5 and 4: " + lca.val); // Should print 5
    }
}

