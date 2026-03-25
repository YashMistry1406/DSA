import java.util.*;


class Node 
{
     int data;
     Node prev; 
     Node next;

     Node (int data1 , Node prev1 , Node next1)
     {
         this.data = data1;
         this.prev = prev1;
         this.next = next1;
     }

     Node (int data1)
     {
         this.data = data1;
         this.prev = null;
         this.next = null;
     }
}

/**
 * Insertion
 */
public class Insertion {

    static Node head;

    /**
     * @param new_data
     * {@summary} add a new element at the start of the linked list 
     */
    static void push(int new_data)
    {
        Node new_node = new Node(new_data);

        new_node.next = head;
        new_node.prev = null;
        
        if(head != null)
        {
            head.prev = new_node;
        }
        head = new_node;
    }
    static void InsertAfter(Node prev_node ,int new_data)
    {
        Node new_node = new Node(new_data);
        if(prev_node == null)
        {
            System.out.println("prev cannot be null");
            return;
        }
        new_node.next = prev_node.next;
        prev_node.next = new_node;
        new_node.prev = prev_node;

        if(new_node.next != null)
        {
            new_node.next.prev = new_node;
        }
    }

    static void InsertBefore(int new_data, Node next_node)
    {
        if(next_node == null)
        {
            System.out.println("Node cannot be null");
            return ;
        }
        Node new_node = new Node(new_data);

        new_node.prev = next_node.prev;
        next_node.prev = new_node;
        new_node.next = next_node;
        if (new_node.prev != null) new_node.prev.next = new_node;
        else head = new_node;
    }

    void append(int new_data)
    {
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
}
