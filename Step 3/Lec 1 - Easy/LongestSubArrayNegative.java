import java.util.*;
import java.math.*;

/**
 * LongestSubArrayNegative
 */
public class LongestSubArrayNegative {

    public static int getLongestSubarray(int []nums, int k) {
		// Write your code here.

        int maxLength = 0 ;
        int sum = 0 ; 
        HashMap<Integer,Integer> preFix = new HashMap<>();
        int n = nums.length;

        for(int i = 0 ; i<n;i++)
        {
            sum += nums[i];

            if(sum == k )
            {
                maxLength =Math.max(maxLength,i+1);
            }
            int rem = sum - k ; 

            if(preFix.containsKey(rem))
            {
                int len = i - preFix.get(rem);
                maxLength = Math.max(maxLength, len);
                
            }
            if (!preFix.containsKey(sum)) {
                preFix.put(sum, i);
            }
        }
        return maxLength;
	}
}