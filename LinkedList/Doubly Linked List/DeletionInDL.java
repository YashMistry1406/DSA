
class Node 
{

     int data;
     Node prev; 
     Node next;

     Node (int data1 , Node prev1 , Node next1)
     {
         this.data = data1;
         this.prev = prev1;
         this.next = next1;
     }

     Node (int data1)
     {
         this.data = data1;
         this.prev = null;
         this.next = null;
     }
}


/**
 * DeletionInDL
 */
public class DeletionInDL {

    static Node head;

    static void push(int new_data)
    {

        Node new_node = new Node(new_data);

        new_node.next = head;
        new_node.prev = null;
        
        if(head != null)
        {
            head.prev = new_node;
        }
        head = new_node;
    }
    /**
     * @param del
     * @summary Delete a node in doubly linkedlist
     */
    static void DeleteEndNode(Node del)
    {

        // Base case 
        if (head == null || del == null) { 
            return; 
        } 
  
        // If node to be deleted is head node 
        if (head == del) { 
            head = del.next; 
        } 
  
        // Change next only if node to be deleted 
        // is NOT the last node 
        if (del.next != null) { 
            del.next.prev = del.prev; 
        } 
  
        // Change prev only if node to be deleted 
        // is NOT the first node 
        if (del.prev != null) { 
            del.prev.next = del.next; 
        } 
  
        return; 

    }
}
