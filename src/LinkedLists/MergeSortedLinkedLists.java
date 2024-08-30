package LinkedLists;

public class MergeSortedLinkedLists {

    // Definition for a singly-linked list node
    static class ListNode {
        int val; // Value of the node
        ListNode next; // Reference to the next node

        // Constructor to create a new node
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to merge two sorted linked lists into one sorted list
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to act as the starting point of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy; // Pointer to the last node in the merged list

        // Traverse both lists until one of them is exhausted
        while (l1 != null && l2 != null) {
            // Compare the values of the current nodes in both lists
            if (l1.val <= l2.val) {
                // If l1's value is smaller or equal, add l1's node to the merged list
                current.next = l1;
                l1 = l1.next; // Move to the next node in l1
            } else {
                // If l2's value is smaller, add l2's node to the merged list
                current.next = l2;
                l2 = l2.next; // Move to the next node in l2
            }
            // Move to the next node in the merged list
            current = current.next;
        }

        // If there are remaining nodes in either list, append them to the merged list
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the merged list, starting from the next node after the dummy
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage

        // Create first sorted linked list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Create second sorted linked list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // Merge the two sorted linked lists
        ListNode mergedList = mergeTwoLists(l1, l2);

        // Print the merged sorted linked list
        System.out.println("Merged Sorted Linked List:");
        printList(mergedList);
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

