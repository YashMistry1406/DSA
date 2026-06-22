import java.util.*;

public class InfixToPostFix {

    public static int priority(char c) {
        if (c == '^') // Exponent operator has highest precedence
            return 3;
        else if (c == '/' || c == '*') // Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-') // Addition and subtraction have lowest precedence
            return 1;
        else
            return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
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
                while (!st.isEmpty() && priority(c) <= priority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        System.out.println(ans);
    }
}
