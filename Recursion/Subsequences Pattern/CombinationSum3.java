/*
 * Root (sum=5, index=1, size=0)
                ________________________________________|________________________________________
               |                                        |                                        |
             i = 1                                    i = 2                                    i = 3
          Pick num: 1                              Pick num: 2                              Pick num: 3
       State: (4, 2, 1)                         State: (3, 3, 1)                         State: (2, 4, 1)
         ______|______                            ______|______                            ______|______
        |             |                          |             |                          |             |
      i = 2         i = 3                      i = 3         i = 4                      i = 4         i = 5
   Pick num: 2   Pick num: 3                Pick num: 3   Pick num: 4                Pick num: 4   Pick num: 5
State: (2,3,2) State: (1,4,2)            State: (0,4,2) ❌ [BREAK]                ❌ [BREAK]    ❌ [BREAK]
   ____|____     ____|____                      |       (4 > 3 -> stops            (4 > 2)       (5 > 2)
  |         |   |         |                     |        this loop level)
i=3       i=4  i=4       i=5                 ⭐ [FOUND]
Pick:3   Pick:4 Pick:4    Pick:5              🟢 [2, 3]
❌[SIZE]  ❌[SIZE] ❌[SIZE]   ❌[SIZE]
(Size 3>2)(Size 3>2)(Size 3>2)(Size 3>2)
  |         |   |         |
 i=4       i=5 i=5       i=6
Pick:4   Pick:5 Pick:5   Pick:6
❌[BREAK] ❌[BREAK]❌[BREAK] ❌[BREAK]
(4 > 2)   (5 > 2) (5 > 1)  (6 > 1)
 * */

import java.util.*;

class Solution
{

    public void helper(int sum, int index, List<Integer> nums, int k, List<List<Integer>> ans)
    {
        if (sum == 0 && nums.size() == k)
        {
            ans.add(new ArrayList<>(nums));
            return;
        }
        if (sum <= 0 || nums.size() > k)
            return;

        for (int i = index; i <= 9; i++)
        {
            if (i <= sum)
            {
                nums.add(i);
                helper(sum - i, i + 1, nums, k, ans);
                nums.remove(nums.size() - 1);
            } else
                break;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        helper(n, 1, nums, k, ans);
        return ans;

    }
}
