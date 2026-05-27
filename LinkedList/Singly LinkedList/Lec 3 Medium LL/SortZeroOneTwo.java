import java.util.*;

// Node class representing each element of the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize node with a value
    Node(int val) {
        data = val;
        next = null;
    }
}

// LinkedList class to manage list operations
class LinkedList {
    Node head;

    // Constructor to initialize an empty list
    LinkedList() {
        head = null;
    }

    // Function to insert a new node at the end
    void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Function to print the entire linked list
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }
}

// Solution class containing logic for sorting the list
class Solution {
    // Function to sort linked list of 0s, 1s, and 2s by rearranging the links
    void sortZeroOneTwo(LinkedList ll) {
        // Create dummy nodes for 0s, 1s, and 2s
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        // Create tail pointers to add new nodes in respective lists
        Node zeroTail = zeroDummy;
        Node oneTail = oneDummy;
        Node twoTail = twoDummy;

        Node curr = ll.head;

        // Traverse the original list
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        // Connect 0s list to 1s, and 1s to 2s
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        // Update original list head
        ll.head = zeroDummy.next;
    }
}

// Main class to run the code
public class SortZeroOneTwo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Solution sol = new Solution();

        // Inserting nodes into linked list
        ll.insert(1);
        ll.insert(2);
        ll.insert(0);
        ll.insert(1);
        ll.insert(2);
        ll.insert(0);

        System.out.println("Original List:");
        ll.print();

        // Sorting the list
        sol.sortZeroOneTwo(ll);

        System.out.println("Sorted List:");
        ll.print();
    }
}
