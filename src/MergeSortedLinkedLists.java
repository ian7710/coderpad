public class MergeSortedLinkedLists {

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

    // Function to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to serve as the starting point of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists while both have nodes
        while (l1 != null && l2 != null) {
            // Compare the values of the current nodes in both lists
            if (l1.val <= l2.val) {
                // If l1's value is smaller, append it to the merged list
                current.next = l1;
                l1 = l1.next; // Move l1 to the next node
            } else {
                // If l2's value is smaller, append it to the merged list
                current.next = l2;
                l2 = l2.next; // Move l2 to the next node
            }
            // Move current to the next node in the merged list
            current = current.next;
        }

        // If one list is exhausted, append the remaining nodes of the other list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the merged list, starting from the node after the dummy node
        return dummy.next;
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

        // Creating first sorted linked list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        // Merge the two sorted linked lists
        ListNode mergedList = mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}
