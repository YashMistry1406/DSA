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
 * Intersection
 * https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/
 */
public class Intersection {

    static Node head;

    
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

    static void approach1()
    {
    }




    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            append(sc.nextInt());
        }
    }
}
