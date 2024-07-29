import java.util.*;

class Node 
{

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
 * LoopInLL
 */
public class LoopInLL {

    static Node head;

    public boolean CheckLoop()
    {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;

            fast = fast.next.next;

            if(fast == slow)
            {
                return true;
            }
        }

        return false;
    }
}   
