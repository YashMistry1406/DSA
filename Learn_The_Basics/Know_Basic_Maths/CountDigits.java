
import java.util.*;

/**
 * CountDigits
 */
public class CountDigits {

    public static void main(String[] args) {

        // Brute Force

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number to count the digits");
        int num = sc.nextInt();

        int count = 0;
        while (num % 10 != 0) {
            count += 1;
            num = num / 10;
        }
        System.out.println("the count" + count);

        // Optimizes approach

        int cnt = (int) (Math.log10(num) + 1);

        System.out.println("count" + cnt);
    }
}
