package LinkedLists;

public class RemoveNthFromEnd {

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

    // Function to remove the nth node from the end of the list
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases like removing the first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers, both starting at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer n+1 steps ahead so that the gap between first and second is n nodes
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end of the list
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Now, second pointer is at the node before the one to be removed
        second.next = second.next.next; // Remove the nth node from the end

        // Return the head of the modified list
        return dummy.next;
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

        // Remove the 2nd node from the end of the list
        head = removeNthFromEnd(head, 2);

        // Print the modified linked list
        System.out.println("Linked List after removing 2nd node from the end:");
        printList(head);
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

