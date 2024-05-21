import java.util.*;

/**
 * SplitArray
 */
public class SplitArray {

    public int CountSize(int[] arr, int maxSum) {
        int n = arr.length;
        int partitions = 1;
        int subArraySum = 0;

        for (int i = 0; i < n; i++) {
            if (subArraySum + arr[i] <= maxSum) {
                subArraySum += arr[i];
            } else {
                partitions++;
                subArraySum = arr[i];
            }
        }
        return partitions;
    }

    public int splitArray(int[] nums, int k) {

        int low = nums[0];
        int high = 0;
        // find maximum and summation:
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = CountSize(nums, mid);
            if (partitions > k) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;

    }
}
