package TreesAndGraphs;

import java.util.*;

public class SerializeDeserializeBinaryTree {

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

    // Function to serialize a binary tree to a string
    public static String serialize(TreeNode root) {
        // Use a StringBuilder to construct the serialized string
        StringBuilder sb = new StringBuilder();

        // Use a queue to perform level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                // Append "null" for null nodes
                sb.append("null,");
            } else {
                // Append the value of the node
                sb.append(node.val).append(",");

                // Add left and right children to the queue
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // Remove the trailing comma and return the serialized string
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Function to deserialize a string to a binary tree
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null; // If the input string is empty, return null
        }

        // Split the string into an array of values
        String[] nodes = data.split(",");

        // The first value is the root node
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // Use a queue to help in reconstructing the tree using level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second element in the array

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Process the left child
            if (!nodes[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            }
            i++;

            // Process the right child
            if (!nodes[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root; // Return the reconstructed binary tree
    }

    // Helper function to print the tree in level-order for verification
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage

        // Create a binary tree
        //        1
        //       / \
        //      2   3
        //         / \
        //        4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serializedTree = serialize(root);
        System.out.println("Serialized tree: " + serializedTree);

        // Deserialize the string back to a tree
        TreeNode deserializedTree = deserialize(serializedTree);
        System.out.print("Deserialized tree (level-order): ");
        printLevelOrder(deserializedTree);
    }
}

