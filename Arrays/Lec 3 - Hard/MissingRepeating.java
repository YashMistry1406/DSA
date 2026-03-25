import java.util.*;

/**
 * MissingRepeating
 */
public class MissingRepeating {

    public static int[] findMissingRepeatingNumbers(int[] a) {
        // Write your code here

        int n = a.length;
        long SN = n * ((n + 1) / 2);
        long S2N = (n * (n + 1) * ((2 * n) + 1)) / 6;

        long arr_sum = 0;
        long arr_sq_sum = 0;

        for (int i = 0; i < n; i++) {
            arr_sum += a[i];
            arr_sq_sum += (long) (a[i]) * (long) (a[i]);
        }

        // S-Sn = X-Y:
        long val1 = arr_sum - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = arr_sq_sum - S2N;

        val2 = val2/val1;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;

    }
}