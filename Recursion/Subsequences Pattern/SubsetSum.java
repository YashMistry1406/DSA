import java.util.*;

public class SubsetSum
{
    public static void helper(int index, int sum, int[] arr, List<Integer> ans)
    {
        if (index == arr.length)
        {
            ans.add(sum);
            return;
        }
        helper(index + 1, sum, arr, ans);
        helper(index + 1, sum + arr[index], arr, ans);

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int[]

    }
}
