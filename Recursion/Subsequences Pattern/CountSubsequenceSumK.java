import java.util.*;

public class CountSubsequenceSumK
{

    // Global count approach
    static int count = 0;

    public static void countUsingGlobal(int index, int sum, int k, int[] arr)
    {

        if (index == arr.length)
        {
            if (sum == k)
            {
                count++;
            }
            return;
        }

        // Include
        countUsingGlobal(index + 1, sum + arr[index], k, arr);

        // Exclude
        countUsingGlobal(index + 1, sum, k, arr);
    }

    // Return count approach
    public static int countUsingReturn(int index, int sum, int k, int[] arr)
    {

        if (index == arr.length)
        {
            return (sum == k) ? 1 : 0;
        }

        // Include
        int include = countUsingReturn(index + 1, sum + arr[index], k, arr);

        // Exclude
        int exclude = countUsingReturn(index + 1, sum, k, arr);

        return include + exclude;
        // For Yes / No boolean type of return , just change the int in function
        // def to boolean as well
        // return solve(i + 1, n, arr, k - arr[i]) || solve(i + 1, n, arr, k);

    }

    public static void main(String[] args)
    {

        int[] arr = { 1, 0 };
        int k = 1;

        // Global count approach
        count = 0; // reset before use
        countUsingGlobal(0, 0, k, arr);
        System.out.println("Global Count Approach = " + count);

        // Return count approach
        int answer = countUsingReturn(0, 0, k, arr);
        System.out.println("Return Count Approach = " + answer);
    }
}
