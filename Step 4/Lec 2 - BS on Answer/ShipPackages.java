/**
 * ShipPackages
 */
public class ShipPackages {


    public int FindDays(int[] arr , int cap)
    {
        int n = arr.length;
        int load = 0 ; 
        int days = 1 ; 
        for(int i = 0 ; i < n; i++ )
        {
            if(load + arr[i] > cap)
            {
                load = arr[i];
                days += 1;
            }
            else load += arr[i];
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        int low = Integer.MIN_VALUE , high = 0 ; 
        for(int i = 0 ; i< n ; i++)
        {
            high += weights[i];
            low = Math.max(low , weights[i]);
        }

        while(low <= high )
        {
            int mid = (low + high) / 2;
            int numberOfDays = FindDays(weights, mid);
            if (numberOfDays <= days) {
                //eliminate right half
                high = mid - 1;
            } else {
                //eliminate left half
                low = mid + 1;
            }
        }
        return low;
    }
}
