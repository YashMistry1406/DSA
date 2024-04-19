import java.util.*;

/**
 * LongestSuccessive
 */
public class LongestSuccessive {

    public static int longestSuccessiveElements(int[] a) {

        int n = a.length;
        if (n == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer>  set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        for(int it : set)
        {
            if(!set.contains(it - 1 ));
            {
                int count = 1;
                int x = it;

                while(set.contains(x+1))
                {
                    count+=1;
                    x+=1;
                }
                longest = Math.max(count, longest);
            }
        }
       return longest; 

    }
}
