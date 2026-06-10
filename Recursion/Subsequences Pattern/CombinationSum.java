import java.util.*;

class Solution
{
    public static void findSum(int index, int sum, int target, int[] arr, List<Integer> current,
            List<List<Integer>> ans)
    {
        if (sum == target)
        {

            ans.add(new ArrayList<>(current));

            return;
        }
        if (sum > target || index == arr.length)
            return;

        current.add(arr[index]);
        findSum(index + 1, sum + arr[index], target, arr, current, ans);
        current.remove(current.size() - 1);

        findSum(index + 1, sum, target, arr, current, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findSum(0, 0, target, candidates, current, ans);
        return ans;

    }

}
