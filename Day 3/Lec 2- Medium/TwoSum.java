// public static String read(int n, int []book, int target){
//     // Write your code here.
//     // int n = book.length;
//     boolean flag = false;
//     for ( int i = 0 ; i<n ; i ++)
//     {
//          for (int j = 0 ; j < n ; j++)
//          {
//              if( i == j )
//              {
//                 continue;
//              }

//              else if ( book[i]+book[j] == target)
//              {
//                  flag = true;
//                  break;
//              }
//          }
//     }
//     if(flag == true)
//     {
//         return "YES";
//     }
//     else return "NO";
// }

// public static String read(int n, int []book, int target){
//     // Write your code here.
//     // int n = book.length;
//     boolean flag = false;
//     for ( int i = 0 ; i<n-1; i ++)
//     {
//          for (int j = i+1 ; j < n ; j++)
//          {
//              if ( book[i]+book[j] == target)
//              {
//                  flag = true;
//                  break;
//              }
//          }
//     }
//     if(flag == true)
//     {
//         return "YES";
//     }
//     else return "NO";
// }

import java.util.*;

/**
 * 2Sum
 */
public class TwoSum {

    static Scanner sc = new Scanner (System.in);
    public static String twoSum(int n, int []arr, int target) {
        Arrays.sort(arr);

        System.out.println("enter the target");
        target = sc.nextInt();
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "YES";
            } else if (sum < target) left++;
            else right--;
        }
        return "NO";
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

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"-");
        }

    }


    public static void main(String[] args) {
        int [] arr = input();
        
        twoSum(arr.length, arr, 0);
    }
      
}