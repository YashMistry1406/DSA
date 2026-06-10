import java.util.*;

/*Root (ind=0, target=8)
       ____________________________________________|____________________________________________
      |                  |                         |                  |          |        |     |
    i=0                i=1                       i=2                i=3        i=4      i=5   i=6
 Pick arr[0]=1      Pick arr[1]=1             Pick arr[2]=2      Pick arr[3]=5 Pick[4]=6 Pick[5]=7 Pick[6]=10
   Node(1, 7)         🛑 [SKIPPED]              Node(3, 6)         Node(4, 3) Node(5, 2) Node(6, 1) ✂️[BREAK]
      |            (i>ind && 1==1)                 |                  |          |        |    (10 > 8)
   ___|______________________                      |___               |          |        |
  |         |        |       |                     |   |              |          |        |
 i=1       i=2      i=3     i=4                   i=3 i=4            i=4        i=5      i=6
Pick[1]=1 Pick[2]=2 Pick[3]=5 Pick[4]=6          Pick[3]=5 Pick[4]=6 Pick[4]=6  Pick[5]=7 ✂️[BREAK]
Node(2,6) Node(3,5) Node(4,2) Node(5,1)          Node(4,1) ⭐[FOUND]  ✂️[BREAK]  ✂️[BREAK] (7 > 1)
  |         |        |       |                     |     🟢[2, 6]    (6 > 3)    (7 > 2)
  |____     |___     |       |                     |
  |    |    |   |    |       |                    i=4
 i=2  i=3  i=3 i=4  i=4     i=5                  Pick[4]=6
Pick[2]=2 Pick[3]=5 Pick[3]=5 Pick[4]=6          ✂️[BREAK]
Node(3,4) Node(4,1) ⭐[FOUND] ✂️[BREAK]           (6 > 1)
  |    \     |     🟢[1,2,5] (6 > 2)
  |     \    |
 i=3    i=4 i=4
Pick[3]=5 ✂️[BREAK] Pick[4]=6
✂️[BREAK] (6>4) ✂️[BREAK]
(5 > 4)         (6 > 1)
  |
 (Backtrack to Node(2,6) 
  and look at remaining)
  |
 i=4
Pick[4]=6
⭐[FOUND]
🟢[1, 1, 6]
  |
 i=5
Pick[5]=7
✂️[BREAK] (7 > 6)
*/
// Solution class for managing combinations
import java.util.*;

public class CombinationSum2
{
    // Function to find all combinations of numbers that sum up to the
    // target
    public static void findCombination(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds)
    {
        // Base case: If the target becomes 0, we found a valid combination
        if (target == 0)
        {
            ans.add(new ArrayList<>(ds)); // Add the current combination to
                                          // the
                                          // result
            return;
        }

        // Loop through the elements starting from index 'ind'
        for (int i = ind; i < arr.length; i++)
        {
            // Skip duplicates to avoid repeating combinations
            if (i > ind && arr[i] == arr[i - 1])
                continue;

            // If the current element is greater than the remaining target,
            // break the loop
            if (arr[i] > target)
                break;

            // Include the current element in the combination
            ds.add(arr[i]);

            // Recur with the updated target and next index (i + 1 to avoid
            // repetition)
            findCombination(i + 1, target - arr[i], arr, ans, ds);

            // Backtrack by removing the last added element
            ds.remove(ds.size() - 1);
        }
    }

    // Function to calculate all unique combinations that sum up to the
    // target
    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates); // Sort the candidates to handle duplicates
        List<List<Integer>> ans = new ArrayList<>(); // To store the final
                                                     // answer
        List<Integer> ds = new ArrayList<>(); // To store the current
                                              // combination
        findCombination(0, target, candidates, ans, ds); // Call the helper
                                                         // function
        return ans; // Return all valid combinations
    }

    public static void main(String[] args)
    {
        int[] v = { 10, 1, 2, 7, 6, 1, 5 }; // Example input
        int target = 8; // Target sum

        // Get all combinations that sum up to 8
        List<List<Integer>> comb = combinationSum2(v, target);

        // Output the combinations
        System.out.print("[ ");
        for (List<Integer> combination : comb)
        {
            System.out.print("[ ");
            for (int num : combination)
            {
                System.out.print(num + " ");
            }
            System.out.print("]");
        }
        System.out.println(" ]");
    }
}
