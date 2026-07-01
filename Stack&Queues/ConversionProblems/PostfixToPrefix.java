import java.util.*;

class PostfixToPrefix {
    // Function to convert postfix to prefix
    public String postfixToPrefix(String postfix) {
        Stack<String> s = new Stack<>();
        int n = postfix.length();

        // Traverse the postfix expression from left to right
        for (int i = 0; i < n; i++) {
            char c = postfix.charAt(i);

            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c)) {
                s.push(String.valueOf(c));
            } else {
                // Pop two operands from the stack
                String op2 = s.pop();
                String op1 = s.pop();

                // Form the new prefix expression and push back to stack
                s.push(c + op1 + op2);
            }
        }

        // The final element in the stack is the result
        return s.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        PostfixToPrefix converter = new PostfixToPrefix();
        String postfix = "ABC/-AK/L-*";
        System.out.println("Prefix Expression: " + converter.postfixToPrefix(postfix));
    }
}

