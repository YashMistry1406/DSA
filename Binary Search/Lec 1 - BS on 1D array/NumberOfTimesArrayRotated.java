

/**
 * NumberOfTimesArrayRotated
 */
public class NumberOfTimesArrayRotated {

    public static int answer(int[] arr)
    {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {

            int mid = (low + high) / 2;

            if(arr[low]<=arr[high])
            {
                min = Math.min(arr[low],min);
                index = low ;
                break;
            }

            if(arr[low] <= arr[mid])
            {
                min = Math.min(arr[low],min);
                index = low ; 
                low = mid + 1 ;
            }
            else
            {
               min = Math.min(arr[mid], min);
               index = mid;
               high = mid - 1;
            }
        }
        return index ;
    }
}