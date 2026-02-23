import java.util.*;
/**
 * Factorial
 */
public class Factorial {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number for factorial");
        int n = sc.nextInt();

        int ans = factorial(n);

        System.out.println("answer is "+ans);
    }

    public static int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }

        return n*factorial(n-1);
    }
    
}
