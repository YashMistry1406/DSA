
/**
 * SquareRoot
 * 
 * 
 * 
 * public static int floorSqrt(int n) {
        int low = 1, high = n;
        //Binary search on the answers:
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= (long)(n)) {
                //eliminate the left half:
                low = (int)(mid + 1);
            } else {
                //eliminate the right half:
                high = (int)(mid - 1);
            }
        }
        return high;
    }
 */
public class SquareRoot {

    long floorSqrt(long x) {
        // Your code here
        long ans = Integer.MIN_VALUE;

        long low = 0;
        long high = x;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sq = mid * mid;
            if (sq == x)
                return mid;
            else if (sq < x) {
                ans = Math.max(ans,mid);
                low = mid + 1;
            }
            else high = mid - 1 ; 
        }
        return ans;

    }
}
