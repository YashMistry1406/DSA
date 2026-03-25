import java.util.*;
import java.util.ArrayList;

/**
 * Merge
 */
public class Mergesort{



    static int[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array length");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array element");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }

    }


    static void merge(int[] arr, int low , int mid , int high)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid +1 ;

        while (left<=mid && right <= high)
        {
            if(arr[left]<= arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left<=mid)
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
    }



    static void mergeSort(int[] arr,int low, int high) 

    {
        if (low >= high)
        {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }



    public static void main(String[] args) {

        int[] ans=input();
        int high = ans.length;
        mergeSort(ans, 0, high-1);
        print(ans);
    }
}
