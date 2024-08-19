import java.util.*;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data1, Node prev1, Node next1) {
        this.data = data1;
        this.prev = prev1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.prev = null;
        this.next = null;
    }
}

/**
 * DeleteAllOccurences
 */
public class DeleteAllOccurences {

    static Node head;

    static void append(int new_data) {
        Node new_node = new Node(new_data);

        Node last = head;
        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        new_node.prev = last;
    }

    static void printList()
    {
        Node current = head;

        while(current != null)
        {
            System.out.println("Element is --> "+ current.data);
        }
    }



    /**
     * @param key
     */
    static void Delete(int key)
    {
        Node current = head;

        ArrayList<Integer> list = new ArrayList<>();

        while(current != null)
        {
            if(current.data != key)
            {
               list.add(current.data);
            }
        }

        for(int i = 0 ; i < list.size(); i++)
        {
            append(list.get(i));
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            append(sc.nextInt());
        }

        sc.close();
    }

}
