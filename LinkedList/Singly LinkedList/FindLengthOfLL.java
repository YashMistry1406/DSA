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
 * FindLengthOfLL
 */
public class FindLengthOfLL {

    static Node head;

    static int count() {
        Node current = head;
        int count = 0;
        while (current.next != null) {
            count += 1;
            current = current.next;
        }
        return count;
    }

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

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            append(sc.nextInt());
        }

        System.out.println(count());
    }
}
