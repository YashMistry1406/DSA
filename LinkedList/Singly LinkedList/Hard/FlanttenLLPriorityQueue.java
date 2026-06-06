import java.util.PriorityQueue;

class Node
{
    int data;
    Node next;
    Node child; // Represents the down/bottom pointer

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}

public class FlanttenLLPriorityQueue
{

    public static Node flatten(Node root)
    {
        if (root == null)
            return null;

        // Initialize Min-Heap based on node data values
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));

        // Step 1: Push the head of each vertical sub-list into the priority
        // queue
        Node current = root;
        while (current != null)
        {
            minHeap.add(current);
            current = current.next;
        }

        // Step 2: Create a dummy node to build the result list
        Node dummy = new Node(-1);
        Node tail = dummy;

        // Step 3: Process the queue until empty
        while (!minHeap.isEmpty())
        {
            // Pop the smallest node
            Node smallest = minHeap.poll();

            // Append it to our flattened list
            tail.child = smallest;
            tail = tail.child;

            // Step 4: If a child node exists, push it into the queue
            if (smallest.child != null)
            {
                minHeap.add(smallest.child);
            }

            // Clear the next pointer to maintain a single flat list
            smallest.next = null;
        }

        // Return the head of the flattened list
        return dummy.child;
    }

    // Utility method to print the flattened list
    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.child;
        }
        System.out.println("null");
    }

    public static void main(String[] args)
    {
        // Example setup: 3 sorted sub-lists
        // List 1: 5 -> 7 -> 8 -> 30
        Node head1 = new Node(5);
        head1.child = new Node(7);
        head1.child.child = new Node(8);
        head1.child.child.child = new Node(30);

        // List 2: 10 -> 20
        Node head2 = new Node(10);
        head2.child = new Node(20);

        // List 3: 19 -> 22 -> 50
        Node head3 = new Node(19);
        head3.child = new Node(22);
        head3.child.child = new Node(50);

        // Link the main heads horizontally
        head1.next = head2;
        head2.next = head3;

        // Flatten
        Node flattenedHead = flatten(head1);

        // Output: 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 30 -> 50 -> null
        printList(flattenedHead);
    }
}
