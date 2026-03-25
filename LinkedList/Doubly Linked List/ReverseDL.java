
class Node
{
     int data;
     Node back; 
     Node next;

     Node (int data1 , Node back1, Node next1)
     {
         this.data = data1;
         this.back= back1;
         this.next = next1;
     }

     Node (int data1)
     {
         this.data = data1;
         this.back = null;
         this.next = null;
     }
}

/**
 * ReverseDL
 */
public class ReverseDL {

    Node head;


    void push (int new_data)
    {
        Node new_node = new Node(new_data);

        new_node.next = head;
        new_node.back = null;
        
        if(head != null)
        {
            head.back = new_node;
        }
        head = new_node;
    }

    Node reverseDL()
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node prev = null;
        Node current = head;

        while(current!=null)
        {
            prev = current.back;
            current.back = current.next;
            current.next = prev;

            current = current.back;
        }

        return prev.back;

    }
}
