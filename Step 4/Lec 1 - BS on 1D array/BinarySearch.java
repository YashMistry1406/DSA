import java.util.*;

/**
 * BinarySearch
 */
public class BinarySearch {

    public static int Binary(int[] arr , int target)

    {
        int n = arr.length;
        int low = 0 ; 
        int high = n-1;

        while(low<= high)
        {
            int mid = (low+high)/2;
            if(arr[mid]== target) return mid;
            else if(arr[mid] < target) low = mid + 1 ;
            else high = mid - 1 ; 
        }
        return -1; 
    }

    public static int recursiveBinary(int [] arr , int low , int high, int target)
    {
        if(low > high) return -1;
        int mid = (low+high) / 2 ; 

        if(arr[mid] == target) return mid;
        else if (arr[mid] < target) return recursiveBinary(arr, mid+1 , high, target);
        return recursiveBinary(arr, low, mid - 1, target);

    }
}