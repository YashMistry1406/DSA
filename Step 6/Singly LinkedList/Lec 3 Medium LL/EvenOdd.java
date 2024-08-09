import java.util.*;


class Node 
{
    int data; 
    Node next;

    Node(int data1, Node next1)
    {
        this.data = data1;
        this.next=next1;
    }

    Node(int data1)
    {
        this.data = data1;
        this.next=null;
    }


}

/**
 * EvenOdd
 */
public class EvenOdd {

    static Node head;

    static void solve()
    {
        ArrayList<Integer> odd = new ArrayList<>();
        int cnt = 1;
        Node temp = head;
        while(temp.next != null)
        {
            if(cnt%2!=0 && temp == head)
            {
                odd.add(temp.data);
                append(temp.data);
            }
            else if (cnt%2 != 0)
                {
                    odd.add(temp.data);
                }
            cnt++;
            temp = temp.next;
        }
        for(int i = 0 ; i< odd.size();i++)
        {
            System.out.println("odd places values "+odd.get(i));
        }
    }

    static void append(int new_data)
    {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }



    static void print()
    {
        Node temp = head;

        while(temp.next != null)
        {
            System.out.println("Data in the linked list" + temp.data);
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

        solve();
        print();
        sc.close();

    }
}

