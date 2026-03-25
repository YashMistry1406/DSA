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
 * NthNode
 */
public class NthNode {

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

    /**
     * @param index
     *
     * Brute force methods to iterate add to array pop it and then create a linked list again
     */
    static void remove(int index)
    {
        Node current = head;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(current != null)
        {
            temp.add(current.data);
            current=current.next;
        }

       temp.remove(temp.size()-index) ;

        for (int var : temp) {
            System.out.println(var);
        }

    }
    

    static Node optimal_remove(int index)
    {
        Node fast = head;
        Node slow = head;

        for(int i = 0 ; i < index ; i++)
        {
            fast = fast.next;
        }

        if (fast== null)
            return head.next;

        while(fast.next !=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;
    }

    static void print()
    {
        Node current = head;
        while(current!= null)
        {
            System.out.println("Element -->"+current.data);
            current = current.next;
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
        System.out.println("enter the index to be deleted");
        optimal_remove(sc.nextInt());
        print();
        

    }
}
