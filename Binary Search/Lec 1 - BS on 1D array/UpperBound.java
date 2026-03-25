import java.util.*;;


/**
 * UpperBound
 */
public class UpperBound {

    
    public static int uppper(int[] arr, int x)
    {
         int n = arr.length;
         int low = 0 ; 
         int high = n-1;
         int max = n ; 

         while(low <= high)
         {
            int mid = (low+high)/2;

            if(arr[mid] > x)
            {
                 max = mid;
                 high = mid -1 ;
            }
            else
            {
                low = mid + 1;

            }
         }
         return max;
    }
}