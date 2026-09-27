import java.util.*;

class ListNode {
    int data;
    ListNode next;
    ListNode(int value) {
        data = value;
        next = null;
    }
}

class Solution {
    // Function to remove nth node from back using two pointers.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Create n-node gap between fast and slow.
        for (int count = 0; count < n; count++) {
            fast = fast.next;
        }
        
        // Move until fast reaches last node.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Bypass deletion target.
        slow.next = slow.next.next;
        return dummy.next;
    }
}

class RemoveNthNodeFromTail{
    // Function to create linked list from array.
    static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int value : arr) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    // Function to print linked list values.
    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
    }

    // Driver code.
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = createList(arr);
        Solution sol = new Solution();
        head = sol.removeNthFromEnd(head, n);
        printList(head);
    }
}
