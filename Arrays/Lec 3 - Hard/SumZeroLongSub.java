import java.util.*;

/**
 * SumZeroLongSub
 */
public class SumZeroLongSub {

    // Brute force
    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        // Write your code here.
        int max = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[i];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // Optimal approach
    public static int OptimalApproach(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        int max = 0;
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                max = i + 1;
            } else {
                if (hash.get(sum) != null) {
                    max = Math.max(max, i - hash.get(sum));
                } else {
                    hash.put(sum, i);

                }
            }
        }
        return max;
    }

}