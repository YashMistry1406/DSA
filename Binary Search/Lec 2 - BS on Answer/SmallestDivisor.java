/**
 * SmallestDivisor
 */
public class SmallestDivisor {

    public boolean findSum(int[] nums, int div , int limit) {

        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) (arr[i]) / (double) (div));
        }
        if (sum <= limit) {
            return true;
        } else
            return false;

    }

    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;
        if (n > threshold)
            return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (findSum(nums, mid, threshold))
                high = mid - 1;
            else
                low = mid + 1;

        }

        return low;

    }

}
