import java.util.Scanner;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value for factorial");
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    static int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }

        return n * factorial(n-1);

    }

        
}
