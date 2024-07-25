import java.util.*;

class Node {

    int data;
    Node next;

    Node(Node next1, int data1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

/**
 * FindTheHead
 */
public class FindTheHead {

    static Node head;

    static Node FindStart() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                slow = head;

                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }

            }
        }
        return slow;
    }
}
