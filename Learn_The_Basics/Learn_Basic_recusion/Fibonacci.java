import java.util.*;

/**
 * Fibonacci
 */
public class Fibonacci {

    public static int solve(int N) {
        if (N <= 1) {
            return N;
        }

        int last = solve(N - 1);
        int slast = solve(N - 2);

        return last + slast;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the term of fibonacci");
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
