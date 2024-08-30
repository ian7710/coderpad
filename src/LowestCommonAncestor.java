public class LowestCommonAncestor {

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

    // Function to find the Lowest Common Ancestor (LCA) of two nodes in a binary tree
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }

        // If either p or q is the root, then root is the LCA
        if (root == p || root == q) {
            return root;
        }

        // Recursively find LCA in the left and right subtrees
        TreeNode leftLCA = findLCA(root.left, p, q);
        TreeNode rightLCA = findLCA(root.right, p, q);

        // If both leftLCA and rightLCA are non-null, it means p and q are found in different subtrees
        // Hence, the current root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null value (either leftLCA or rightLCA)
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        // Example usage

        // Constructing a sample binary tree:
        //         3
        //        / \
        //       5   1
        //      / \ / \
        //     6  2 0  8
        //       / \
        //      7   4

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;  // Node 5
        TreeNode q = root.left.right.right;  // Node 4

        TreeNode lca = findLCA(root, p, q);

        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }
    }
}

