import java.util.Arrays;

/**
 * KokoEating
 */
public class KokoEating {

    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    public int checkhours(int[] arr, int hours) {
        int totalH = 0;
        int n = arr.length;
        // find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) (arr[i]) / (double) (hours));
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int ans = 0;
        int high = findMax(piles); 
        int low = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int temp = checkhours(piles, mid);
            if (temp == h)
                return mid;
            else if (temp <= h)
                high = mid - 1;
            else
                low = mid + 1;

        }
        return ans;

    }
}
