import java.util.*;

/**
 * ThreeSum
 * https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
 */
public class ThreeSum {

    // Brute force

    public static List<List<Integer>> tripletBruteForce(int n, int[] arr) {

        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

    }

    // Better Approach
    public static List<List<Integer>> tripletBetter(int n, int[] arr) {


        Set<List<Integer>> st = new HashSet<>();

        for(int i = 0 ; i < n ; i ++ )
        {
            Set<Integer> hashset = new HashSet<>();
            for ( int j = i + 1 ; j < n ; j ++)
            {
                int third = -(arr[i]+arr[j]);

                if(hashset.contains(third))
                {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(arr[j]);

            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }


    //Optimal approach 
    public static List<List<Integer>> tripletOptimal(int n, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int k = n ; 
        int j = 0 ; 
        for ( int i = 0 ; i < n ; i ++)
        {
            if(i != 0  && arr[i]==arr[i-1]) continue;

            j = i + 1 ; 
            k = n - 1 ;
            
            while(j < k )
            
            {
                int sum = arr[i]+arr[j]+arr[k]; 
                if(sum < 0 )
                {
                    j++; 
                }
                
                if(sum > 0 )
                {   
                    k--;

                }
                else
                {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;

                }
            }
        }

        return ans;
    }


}