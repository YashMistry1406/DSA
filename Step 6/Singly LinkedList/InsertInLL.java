import java.util.*;

/**
 * InsertInLL
 */
public class InsertInLL {
    static Node head;

    static void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * @param new_data
     *                 {@summary} adds new element at the start of the linkedlist
     */
    public static void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    /**
     * {@summary} add element at the end of the linkedList
     * 
     * @param new_data
     */
    static void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
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
        printList();

        sc.close();
    }

}
