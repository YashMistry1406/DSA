import java.util.*;
/**
 * Armstrong
 */
public class Armstrong {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter to check armstrong");
        int n = sc.nextInt();


        int temp = n;
        int compare = n;
        int count = 0;
        while (n % 10 != 0) {
            count += 1;
            n = n / 10;
        }


        int sum = 0;
        while(temp>0)
        {
            int ld = temp % 10;             // Last digit
            sum += Math.pow(ld, count);      // Add ld^k
            temp/=10;
        }

        if (sum == compare) System.out.println("True");
        else System.out.println("false");

    }
    
    
}
