import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

/**
 * DeleteNodeInLL
 */
public class DeleteNodeInLL {

    static Node head;

    static void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new Node(new_data);
        }
        new_node.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    static void deleteNode(int position) {
        // If linked list is empty
        if (head == null)
            return;
        Node temp = head;
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;
        temp.next = next; // Unlink the deleted node from list
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            append(sc.nextInt());
        }

        deleteNode(3);
    }
}
