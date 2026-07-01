import java.util.*;

public class InfixToPrefix{

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

    public static String infixToPostFix(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                ans.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() &&
                        (isRightAssociative(c)
                                ? getPriority(c) < getPriority(st.peek()) // strict less-than for right-assoc
                                : getPriority(c) <= getPriority(st.peek()))) { // less-or-equal for left-assoc
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }

    public static String infixToPrefix(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '(')
                sb.setCharAt(i, ')');
            if (ch == ')')
                sb.setCharAt(i, '(');
        }
        String prefix = infixToPostFix(sb.toString());
        return new StringBuilder(prefix).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(infixToPrefix(s));

    }
}
