import java.util.*;
public class NbyThree {
    public static List< Integer > majorityElement(int []v) {
        // Write your code here

        //My approach 9/11 test cases passed
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new List<Integer>() ;
        int n = v.length;
//        for (int i = 0 ; i < n; i++)
//        {
//            if(map.containsKey(v[i]))
//            {
//                map.put(v[i], map.get(v[i])+1);
//                if(map.get(v[i])==(n/3))
//                {
//                    ans.add(map.get(v[i]));
//
//                }
//            }
//            else
//            {
//                map.put(v[i], 1);
//            }
//        }
//

        for ( int i = 0 ; i < n ; i ++)
        {
            int mini = map.getOrDefault(v[i], 0);
            map.put(v[i], value+1);

            if(map.get(v[i]) == mini)
            {
                ans.add(v[i]);
            }
            if(ans.size == 2) break;
        }




    return ans;
    }
}
