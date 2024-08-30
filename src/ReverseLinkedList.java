public class ReverseLinkedList {

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

    // Function to reverse the linked list
    public static ListNode reverseList(ListNode head) {
        // Initialize three pointers: prev (previous node), current (current node), and next (next node)
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        // Traverse the linked list
        while (current != null) {
            // Store the next node
            next = current.next;

            // Reverse the current node's pointer to point to the previous node
            current.next = prev;

            // Move the prev and current pointers one step forward
            prev = current;
            current = next;
        }

        // At the end, prev will be the new head of the reversed list
        return prev;
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
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
