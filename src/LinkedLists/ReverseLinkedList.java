package LinkedLists;

public class ReverseLinkedList {

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

    // Function to reverse the linked list
    public static ListNode reverseList(ListNode head) {
        // Initialize three pointers: prev, current, and next
        ListNode prev = null; // Initially, there is no previous node
        ListNode current = head; // Start with the head of the list
        ListNode next = null; // The next node to process

        // Traverse the linked list
        while (current != null) {
            // Store the next node
            next = current.next;

            // Reverse the current node's pointer
            current.next = prev;

            // Move the pointers one position ahead
            prev = current;
            current = next;
        }

        // Return the new head of the reversed list (prev is now the head)
        return prev;
    }

    public static void main(String[] args) {
        // Example usage

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // Print the reversed linked list
        System.out.println("Reversed Linked List:");
        printList(reversedHead);
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

