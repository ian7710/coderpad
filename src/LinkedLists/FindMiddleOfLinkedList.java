package LinkedLists;

public class FindMiddleOfLinkedList {

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

    // Function to find the middle of a linked list
    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        ListNode slow = head; // Slow pointer moves one step at a time
        ListNode fast = head; // Fast pointer moves two steps at a time

        // Traverse the list until fast pointer reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by one step
            fast = fast.next.next;   // Move fast pointer by two steps
        }

        // When fast pointer reaches the end, slow pointer will be at the middle
        return slow;
    }

    public static void main(String[] args) {
        // Example usage

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find the middle of the linked list
        ListNode middle = findMiddle(head);

        // Print the value of the middle node
        if (middle != null) {
            System.out.println("The middle of the linked list is: " + middle.val);
        } else {
            System.out.println("The linked list is empty.");
        }
    }
}

