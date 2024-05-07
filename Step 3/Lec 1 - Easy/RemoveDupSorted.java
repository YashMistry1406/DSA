import java.util.*;
/**
 * RemoveDupSorted
 */
public class RemoveDupSorted {

    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        int count = 0;
        for(int i =0 ; i < n-1 ; i++)
        {
            if(arr[i]!=arr[i+1])
            {
                count++;
            }
        }
        return count+1;
    }

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

    public static void main(String[] args) {

        int[] arr=input();
        int ans = removeDuplicates(arr,arr.length);
        System.out.println(ans);
    }
}