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
    Node(){
        this.next=null;
    }
}

/**
 * AddTwoLL
 */
public class AddTwoLL {
    
    static void append(Node head, int new_data)
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



    static void solve(Node head1,Node head2)
    {
        Node dummy = new Node();
        Node temp = dummy;
        int carry = 0 ;

        while(head1 != null || head2 != null || carry==1)
        {
            int sum = 0;
            if(head1 != null)
            {
               sum += head1.data;
               head1 = head1.next;
            }

            if(head2 != null)
            {
                sum += head2.data;
                head2 = head2.next;
            }

            sum+= carry;
            carry = sum/10;
            Node node = new Node(sum % 10); 
            temp.next = node; 
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements for the 1st LL");
        int n1 = sc.nextInt();
        Node head = new Node(0);
        System.out.println("enter the elements");
        for (int i = 0; i < n1; i++) {
            if(i == 0)
            {
                head = new Node(sc.nextInt());
            }
            else{
            append(head,sc.nextInt());
            }
        }


        System.out.println("enter the number of elements for the 2nd LL");
        int n2 = sc.nextInt();
        Node head1 = new Node(0);
        System.out.println("enter the elements");
        for (int i = 0; i < n2 ; i++) {
            if(i == 0)
            {
                head1 = new Node(sc.nextInt());
            }
            else{
            append(head1,sc.nextInt());
            }
        }


    }
}
