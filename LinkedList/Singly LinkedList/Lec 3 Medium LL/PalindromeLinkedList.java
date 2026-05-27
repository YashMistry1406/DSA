import java.util.*;

class Node
{
    int data;
    Node next;

    Node(int data1, Node next1)
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
public class PalindromeLinkedList
{

    static Node head;

    public Node reverseLinkedList(Node head)
    {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null)
        {
            return head; // No change is needed; return the current head
        }

        // Recursive step: Reverse the remaining part of the list and get the
        // new head
        Node newHead = reverseLinkedList(head.next);

        // Store the next node in 'front' to reverse the link
        Node front = head.next;

        // Update the 'next' pointer of 'front' to point to the current head
        front.next = head;

        // Set the 'next' pointer of the current head to null to break the
        // original link
        head.next = null;

        // Return the new head obtained from the recursion
        return newHead;
    }

    static void append(int new_data)
    {

        Node new_node = new Node(new_data);

        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;

        while (last.next != null)
        {
            last = last.next;
        }

        last.next = new_node;
    }

    static boolean isPalindrome()
    {
        ArrayList<Integer> map = new ArrayList<>();

        Node curr = head;

        while (curr != null)
        {
            map.add(curr.data);
            curr = curr.next;
        }

        int n = map.size();
        int flag = 0;

        // System.out.println("Array lenght --> " + n );
        // for(int i = 0 ; i < n ; i++)
        // {
        // System.out.println("Array elements --> " + map.get(i));
        // }
        //

        int start = 0;
        int end = n - 1;

        while (start < end)
        {
            if (map.get(start) != map.get(end))
            {
                flag = 1;
                break;
            }

            start++;
            end--;
        }

        if (flag == 1)
        {
            return false;

        } else
            return true;

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++)
        {
            append(sc.nextInt());
        }
        System.out.println(isPalindrome());

        sc.close();

    }
}
