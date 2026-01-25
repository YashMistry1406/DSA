import java.util.*;

/**
 * GCD
 */
public class GCD {

    public static int findGCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else
                b = b % a;
        }
        if(a==0) return b;

        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Brute Force
        System.out.println("Enter 2 number to check GCD or HCF");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int small = (n1 < n2) ? n1 : n2;

        int ans = 1;
        for (int i = 1; i <= small; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                ans = i;
            }
        }

        System.out.println("GCD" + ans);

        // Euclidean algorithm

        System.out.println("using euclidean algo"+ findGCD(n1,n2));
    }
}
