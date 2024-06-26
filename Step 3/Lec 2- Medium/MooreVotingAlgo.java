import java.util.*;

/**
 * MooreVotingAlgo
 */
public class MooreVotingAlgo {

    public static int majorityElement(int []v) {
        // Write your code here

        int el = 0 ; 
        int cnt = 0 ; 
        int n = v.length;
        for(int i =0; i<n; i++ )
        {
            if(cnt ==0)
            {
                cnt = 1 ; 
                el = v[i];
            }
            else if (el == v[i]) cnt ++;

            else cnt --;

        }
        int  cnt1= 0 ; 

        for(int i = 0; i<n; i++)
        {
            if(v[i]==el)
            {
                cnt1++;
            }
        }
        if(cnt1 >(n/2) ) return el;
        return -1;
    }
}