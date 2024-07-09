import java.util.*;

class Node
{
    int data;
    Node next;

    Node(int data1)
    {
        this.data = data1;
        this.next = null;
    }
    Node(int data1 , Node next1)
    {
        this.data = data1;
        this.next = next1;
    }
}


/**
 * ReverseLL
 */
public class ReverseLL {
    
    static Node head;

    Node reverse()
    {

        Node prev = null;
        Node temp = head ;

        while(temp != null)
        {
            Node front = temp.next;

            temp.next = prev;

            prev = temp;

            temp = front;
            
        }

        return prev ;
    }


}

