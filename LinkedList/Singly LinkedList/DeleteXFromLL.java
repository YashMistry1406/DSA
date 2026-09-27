class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteXFromLL {
    public static ListNode deleteAllOccurrences(ListNode head, int X) {
        // Skip all matching elements at the beginning of the list
        while (head != null && head.val == X) {
            head = head.next;
        }

        ListNode curr = head;
        // Traverse and bypass matching elements down the line
        while (curr != null && curr.next != null) {
            if (curr.next.val == X) {
                curr.next = curr.next.next; // Delete the next node
            } else {
                curr = curr.next; // Move forward only if we didn't delete
            }
        }

        return head;
    }

    public static ListNode deleteNode(ListNode head, int X) {
        // 1. Check if the list is empty
        if (head == null) {
            return null;
        }

        // 2. Handle the case where the head node contains the value X
        if (head.val == X) {
            return head.next;
        }

        // 3. Traverse the list to find X
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val == X) {
                prev.next = curr.next; // Bypass the node
                return head; // Return the original head
            }
            prev = curr;
            curr = curr.next;
        }

        // Return original head if X was not found
        return head;
    }
}
