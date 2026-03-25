import java.util.*;




class Node
{
    int data;
    Node next;

    Node(int data1,Node next1)
    {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1)
    {
        this.data = data1;
        this.next = null;
    } 
}


/**
 * PalindromeLinkedList
 */
public class PalindromeLinkedList {

    static Node head;

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
    static boolean isPalindrome()
    {
        ArrayList<Integer> map = new ArrayList<>();

        Node curr = head;

        while(curr != null)
        {
            map.add(curr.data);
            curr= curr.next;
        }

        int n = map.size();
        int flag = 0;

    //        System.out.println("Array lenght --> " + n );
    //    for(int i = 0 ; i < n ; i++)
    //    {
    //        System.out.println("Array elements --> " + map.get(i));
    //    }
    //

        int start = 0 ;
        int end = n-1;

        while(start < end )
        {
            if(map.get(start) != map.get(end))
            {
                flag = 1;
                break;
            }

            start ++;
            end --;
        }

        if (flag ==1 ) {
            return false;
            
        }
        else return true;

    }


    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            append(sc.nextInt());
        }
        System.out.println(isPalindrome());

        sc.close();

    }
}

