import java.util.*;

/**
 * MissingRepeating
 */
public class MissingRepeating {

    public int[] findMissingRepeatingNumbersUsingXOR(int[] nums) {
        // Size of the array
        int n = nums.length;

        // XOR of all elements and numbers from 1 to n
        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ nums[i]; // XOR with array element
            xr = xr ^ (i + 1); // XOR with natural number
        }

        // Get the rightmost set bit in xr
        int number = (xr & ~(xr - 1));

        // Two groups based on this bit
        int zero = 0, one = 0;

        // Divide nums into groups and XOR within each group
        for (int i = 0; i < n; i++) {
            if ((nums[i] & number) != 0) {
                one ^= nums[i];
            } else {
                zero ^= nums[i];
            }
        }

        // Divide natural numbers 1 to n into groups and XOR
        for (int i = 1; i <= n; i++) {
            if ((i & number) != 0) {
                one ^= i;
            } else {
                zero ^= i;
            }
        }

        // Check which is repeating and which is missing
        int cnt = 0;
        for (int val : nums) {
            if (val == zero)
                cnt++;
        }

        if (cnt == 2) {
            return new int[] { zero, one }; // zero is repeating
        }
        return new int[] { one, zero }; // one is repeating
    }

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

        val2 = val2 / val1;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = { (int) x, (int) y };
        return ans;

    }
}
