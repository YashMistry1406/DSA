import java.util.*;


 /** int start = 0;
    int end = n - 1;
    int res = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (v[mid] == key) {
        res = mid;
        start = mid + 1;

      } else if (key < v[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
 */
public class LastOccurence {

    public static int Occurence(int[] arr, int target)
    {
            int ans = -1;
            int n = arr.length;
            int low = 0;
            int high = n -1 ;
            while(low <= high)
            {
                int mid = (low+high)/2;

                if(arr[mid] == target)
                {
                    ans = Math.max(ans,mid);
                }
                else if(arr[mid] < target) low = mid + 1;
                else high = mid - 1; 
            }

            return ans;
    }
}