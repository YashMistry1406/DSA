
class Node
{
    int data;
    Node next;
    Node prev;

    Node(int data1, Node prev1 , Node next1)
    {
        this.data = data1;
        this.prev = prev1;
        this.next = next1;
    }

    Node(int data1)
    {
        this.data = data1;
        this.next = null;
        this.prev= null;
    }
}

/**
 * SearchInDL
 */
public class SearchInDL {

    static Node head;

    static boolean search(int element)
    {
        Node current = head;

        while(current.next != null)
        {
            if(current.data == element)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
