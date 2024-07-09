//import java.util.*;
///**
// * MiddleOfLL
// */
//class Node{
//
//    int data; 
//    Node next;
//
//    Node (int data1 , Node next1)
//    {
//        this.data = data1;
//        this.next = next1;
//    }
//    Node(int data1)
//    {
//        this.data = data1;
//        this.next = null;
//    }
//}
//
//
///**
// * MiddleOfLL
// */
//public class MiddleOfLL {
//
//    static Node head;
//
//    static void push(int new_data)
//    {
//        Node new_node = new Node(new_data);
//        new_node.next = head;
//        head = new_node;
//    }
//
//    /**
//     * @return
//     *
//     * Brute force method 
//     */
//    static int middle()
//    {
//        if(head == null || head.next == null )
//        {
//            return head.data;
//        }
//        Node temp = head;
//        int count = 0 ; 
//        while(temp != null)
//        {
//            count++;
//            temp = temp.next;
//        }
//        int mid = count / 2 + 1; 
//        temp = head;
//        while(temp != null)
//        {
//            mid = mid - 1; 
//            if(mid == 0)
//            {
//               break; 
//            }
//            temp = temp.next;
//        }
//            return temp.data;
//    }
//
//
//    static int _2Pointer()
//    {
//        Node slow = head ; 
//        Node fast = head ; 
//
//        while (fast != null && fast.next != null && slow != null)
//        {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow.data;
//    }
//
//    public static void main(String[] args) {
//        
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the number of elements");
//        int n = sc.nextInt();
//        System.out.println("enter the elements");
//        for (int i = 0; i < n; i++) {
//            push(sc.nextInt());
//        }
//
//        System.out.println(middle());
//    }
//}

import java.util.*;

// Node class represents a node in a linked list
class Node {
    // Data stored in the node
    int data; 
     // Pointer to the next node in the list
    Node next;     

    // Constructor with both data
    // and next node as parameters
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleOfLL{
    
    static Node findMiddle(Node head) {
        // Initialize the slow pointer to the head.
        Node slow = head; 
        
        // Initialize the fast pointer to the head.
        Node fast = head;   

        // Traverse the linked list using
        // the Tortoise and Hare algorithm.
        while (fast != null && fast.next != null && slow != null) {
            // Move fast two steps.
            fast = fast.next.next;  
            // Move slow one step.
            slow = slow.next;        
        }
        // Return the slow pointer,
        // which is now at the middle node.
        return slow;  
    }


    public static void main(String[] args) {
        // Creating a sample linked list:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Find the middle node
        Node middleNode = findMiddle(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode.data);
    }
}
