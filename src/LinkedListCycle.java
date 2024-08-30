public class LinkedListCycle {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        // Constructor to initialize the node with a value
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to detect a cycle in the linked list
    // If a cycle is detected, it also removes the cycle
    public static void detectAndRemoveCycle(ListNode head) {
        if (head == null || head.next == null) {
            return; // No cycle possible if list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect Cycle using Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one
            fast = fast.next.next;    // Move fast pointer by two

            if (slow == fast) {       // Cycle detected
                System.out.println("Cycle detected.");
                removeCycle(slow, head);
                return;
            }
        }

        System.out.println("No cycle detected.");
    }

    // Function to remove the cycle in the linked list
    private static void removeCycle(ListNode loopNode, ListNode head) {
        ListNode ptr1 = loopNode;
        ListNode ptr2 = head;

        // Step 2: Find the start of the cycle
        // Move ptr1 to the start of the cycle and ptr2 to the head of the list.
        // Keep moving both pointers one step at a time until they meet.
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Step 3: Break the cycle
        // The node where they meet is the starting node of the cycle.
        // To remove the cycle, we need to set the next pointer of the last node in the cycle to null.
        ptr1.next = null;
        System.out.println("Cycle removed.");
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating a cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        // Detect and remove the cycle
        detectAndRemoveCycle(head);

        // Print the list after cycle removal
        System.out.println("Linked list after removing cycle:");
        printList(head);
    }
}

