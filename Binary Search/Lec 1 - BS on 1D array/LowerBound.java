import java.util.*;

/**
 * LowerBound
 */
public class LowerBound {

    public static int lower(int[] arr, int x)
    {

        int n = arr.length;
        int low = 0 ; 
        int high = n - 1 ; 
        int max = n;
    while ( low <= high )
    {
        int  mid = (low+high)/2;
         if(arr[mid] >= x )
        {
            max = mid ; 
            high = mid - 1 ; 
        }
        else
        {
            low = mid + 1;
        }
    }


        return max;
    }
}