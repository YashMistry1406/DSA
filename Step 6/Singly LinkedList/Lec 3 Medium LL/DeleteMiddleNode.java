import java.util.*;


class Node 
{
    int data;
    Node next;

    Node(int data1, Node next1)
    {
        this.data=data1;
        this.next=next1;
    }
    Node(int data1)
    {
        this.data=data1;
        this.next=null;
    }
}





/**
 * DeleteMiddleNode
 */
public class DeleteMiddleNode {

    static Node head ;

    static void print()
    {
        Node current = head;
        while(current!= null)
        {
            System.out.println("Element -->"+current.data);
            current = current.next;
        }
    }


    static void append(int new_data)
    {
        Node current = head;
        Node new_node = new Node(new_data);


        if(head == null)
        {
            head = new Node(new_data);
            return; 
        }
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = new_node;
    }


    static void middle()
    {
        Node fast = head.next;
        Node slow = head;

        while(fast != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            append(sc.nextInt());
        }

        middle();

        print();
        sc.close();

    }


}
