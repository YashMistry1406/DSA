import java.util.*;

public class PostfixToInfix {

    public static int getPriority(char c) {
        if (c == '^') // Exponent operator has highest precedence
            return 3;
        else if (c == '/' || c == '*') // Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-') // Addition and subtraction have lowest precedence
            return 1;
        else
            return -1;
    }

    public static boolean isRightAssociative(char c) {
        return c == '^';
    }

    public static String postToIn(String post) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < post.length(); i++) {
            char ch = post.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String t1 = st.pop(); // right operand
                String t2 = st.pop(); // left operand

                String con = "(" + t2 + ch + t1 + ")";
                st.push(con);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String post = "ab+c*";
        System.out.println(postToIn(post));
    }
}
