
/**
 * MinInSortedArray
 */
public class MinInSortedArray {

    public static int minimum(int[] arr) {

        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {

            int mid = (low + high) / 2;

            if(arr[low]<=arr[high])
            {
                min = Math.min(arr[low],min);
                break;
            }

            if(arr[low] <= arr[mid])
            {
                min = Math.min(arr[low],min);
                low = mid + 1 ;
            }
            else
            {
               min = Math.min(arr[mid], min);
               high = mid - 1;
            }
        }
        return -1 ;
    }
}

