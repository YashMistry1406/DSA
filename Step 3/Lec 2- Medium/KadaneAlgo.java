import java.util.*;

/**
 * KadaneAlgo
 */
public class KadaneAlgo
{

    public static void PrintTheSubArry(int[] nums)
    {

        // Maximum sum
        long maxi = Long.MIN_VALUE;

        // Current sum of subarray
        long sum = 0;

        // Starting index of current subarray
        int start = 0;

        // Indices of the maximum sum subarray
        int ansStart = -1, ansEnd = -1;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++)
        {

            // Update starting index if sum is reset
            if (sum == 0)
            {
                start = i;
            }

            // Add current element to the sum
            sum += nums[i];

            // Update maxi and subarray indices if current sum is greater
            if (sum > maxi)
            {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            // Reset sum to 0 if it becomes negative
            if (sum < 0)
            {
                sum = 0;
            }
        }

        // Printing the subarray
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        // Return the maximum subarray sum found
    }

    public static long maxSubarraySum(int[] arr, int n)
    {
        // write your code here
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        for (int i = 0; i < n; i++)
        {

            sum += arr[i];

            if (sum > maxi)
            {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0)
            {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        if (maxi < 0)
            maxi = 0;

        return maxi;
    }
}
