package LinkedLists;

public class LinkedListCycle {

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

    // Function to detect and remove a cycle in the linked list
    public static void detectAndRemoveCycle(ListNode head) {
        if (head == null || head.next == null) {
            return; // If the list is empty or has only one node, there is no cycle
        }

        ListNode slow = head; // Slow pointer
        ListNode fast = head; // Fast pointer

        // Step 1: Detect if there is a cycle using Floyd's Cycle Detection Algorithm (Tortoise and Hare)
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by one step
            fast = fast.next.next;   // Move fast pointer by two steps

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                removeCycle(head, slow); // Call function to remove the cycle
                return;
            }
        }
    }

    // Function to remove the cycle in the linked list
    private static void removeCycle(ListNode head, ListNode meetingPoint) {
        ListNode ptr1 = head;
        ListNode ptr2 = meetingPoint;

        // Step 2: Find the start of the cycle
        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Step 3: Remove the cycle by setting the next of the cycle's last node to null
        ptr2.next = null;
    }

    public static void main(String[] args) {
        // Example usage

        // Create a linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Creating a cycle at node 3

        // Detect and remove the cycle
        detectAndRemoveCycle(head);

        // Print the modified list after removing the cycle
        System.out.println("Linked List after removing cycle:");
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

