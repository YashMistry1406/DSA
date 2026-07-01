import java.util.*;


public class NextGreatElement {

    public int[] GreaterElement(int[] nums)
    {
        Stack<Integer> st = new Stack<>();

        int[] nge = new int[st.size()];
        for(int i = st.size(); i > 0; i--)
        {
            while(!st.isEmpty() && st.peek()<=nums[i])
            {
                st.pop();
            }
            if(st.isEmpty()) nge[i]= -1; 
            else nge[i] =st.peek();
            st.push(nums[i]);
        }
        return nge;
    }
    public static void main(String[] args) {
        
    }
}
