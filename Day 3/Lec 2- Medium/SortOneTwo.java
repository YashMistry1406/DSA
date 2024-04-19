import java.util.* ;
import java.io.*; 
public class SortOneTwo 
{
    public static void sort012(int[] arr)
    {
        //Write your code here
        int low = 0 ;
       int mid = 0; 
       int n = arr.length;
       int high = n-1;

        while(mid<=high)
       {
           if(arr[mid]==0)
           {
               int temp = arr[low];
               arr[low] = arr[mid];
               arr[mid ] = temp;
               low++;
               mid ++;
           }
           else if(arr[mid]==1)
           {
               mid++;
           }
           else
           {
               int temp = arr[mid];
               arr[mid] = arr[high];
               arr[high] = temp;
               high--;
           }
       }

       

    
    }
}