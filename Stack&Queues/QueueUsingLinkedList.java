import java.util.*;

// Node structure
class Node {
    int val;
    Node next;
    Node(int d) {
        val = d;
        next = null;
    }
}

// Structure to represent queue
class LinkedListQueue {
    private Node start; // Start of the queue
    private Node end; // End of the queue
    private int size; // Size of the queue

    // Constructor
    public LinkedListQueue() {
        start = end = null;
        size = 0;
    }

    // Method to push an element in the queue
    public void push(int x) {
        // Creating a node
        Node element = new Node(x);
        
        // If it is the first element being pushed
        if (start == null) {
            // Initialize the pointers
            start = end = element;
        } else {
            end.next = element; // Updating the pointers
            end = element; // Updating the end
        }
        
        // Increment size by 1
        size++;
    }

    // Method to pop an element from the queue
    public int pop() {
        // If the queue is empty
        if (start == null) {
            return -1; // Pop operation cannot be performed
        }
        
        int value = start.val; // Get the front value
        Node temp = start; // Store the front temporarily
        start = start.next; // Update front to next node
        temp = null; // Delete old front node
        size--; // Decrement size
        
        return value; // Return data
    }

    // Method to get the front element in the queue
    public int peek() {
        // If the queue is empty
        if (start == null) {
            return -1; // Front element cannot be accessed
        }
        
        return start.val; // Return the front
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }
}

class Main {
    public static void main(String[] args) {
        // Creating a queue
        LinkedListQueue q = new LinkedListQueue();

        // Array of commands
        String[] commands = {"LinkedListQueue", "push", "push", 
                             "peek", "pop", "isEmpty"};
        // Array of inputs
        int[][] inputs = {{}, {3}, {7}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListQueue")) {
                System.out.print("null ");
            }
        }
    }
}
