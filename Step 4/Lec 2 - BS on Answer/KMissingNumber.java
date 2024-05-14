/**
 * KMissingNumber
 */
public class KMissingNumber {


    //Brute force 
    /** public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int ans = 0 ;  
        for(int i = 0 ; i < n ; i++ )
        {
            if(arr[i] <= k )
            {
                k+=1;
            }
            else break;
        }

        return k;
    }**/


    //Optimal Using Binary search 
    //missing = arr[mid] - mid + 1 --- 1 
    //more = k - missing --- 2 
    //ans = arr[mid] + more ---3 
    //put the value of 2 in 3 and 1 in 2 

    public int findKthPositive(int[] arr, int k) {

        int n = arr.length;
        int low = 0 , high = n - 1; 
        
        while(low <= high )
            {
                int mid = (low + high) / 2 ; 

                int missing = arr[mid] - (mid + 1) ;
                if ( missing < k ) low = mid + 1 ;
                else high = mid - 1 ; 

            }
        return (high+1+k); // low + k  this is taken for condition like {4,7,8} where the high pointer 
                           // will  be at -1 
    }
}
