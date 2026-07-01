import java.util.*;

public class PrefixToInfix {

    public static String preToIn(String pre) {
        Stack<String> st = new Stack<>();

        for (int i = pre.length() - 1; i >= 0; i--) {
            char ch = pre.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String t1 = st.pop(); // right operand
                String t2 = st.pop(); // left operand

                String con = "(" + t1 + ch + t2 + ")";
                st.push(con);
            }
        }
        return st.peek();
    }
}
