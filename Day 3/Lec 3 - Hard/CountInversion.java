import java.util.*;

/**
 * CountInversion
 */
public class CountInversion {

    public static int merge(int[] arr , int low , int mid , int high)
    {
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low ; 
        int right = mid+1;
        int cnt = 0 ;
        while(left <= mid && right <= high)
        {
            if(arr[left]<=arr[right])
            {
                temp.add(arr[left]);
                left++;                
            }
            else
            {
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }

        }

        while(left<mid)
        {
            temp.add(arr[left]);
            left++;
        }
        while(right<=high)
        {
            temp.add(arr[right]);
            right++;
        }
            
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return cnt ; 

    }

    public static int MergeSort(int[]arr , int low ,int high)
    {
        int cnt = 0 ; 
        if(low>=high) return cnt; 
        int mid = (low+high)/2;
        MergeSort(arr,low,mid);
        MergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);

        return cnt ; 
    }
}