import java.util.*;

class Solution
{
    // Function to insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> st, int val)
    {
        // If stack is empty, push the value
        if (st.isEmpty())
        {
            st.push(val);
            return;
        }

        // Pop the top element
        int topVal = st.pop();

        // Recurse for the rest of the stack
        insertAtBottom(st, val);

        // Push the popped element back
        st.push(topVal);
    }

    // Function to reverse the stack
    public static void reverseStack(Stack<Integer> st)
    {
        // Base case: If stack is empty, return
        if (st.isEmpty())
            return;

        // Pop the top element
        int topVal = st.pop();

        // Recursively reverse the remaining stack
        reverseStack(st);

        // Insert the popped element at the bottom
        insertAtBottom(st, topVal);
    }
}

public class ReverseStack
{
    public static void main(String[] args)
    {
        // Create a sample stack
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        // Reverse the stack
        Solution.reverseStack(st);

        // Print the reversed stack
        System.out.print("Reversed Stack: ");
        while (!st.isEmpty())
        {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
}
