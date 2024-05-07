import java.util.*;

/**
 * RotateArray
 */
public class RotateArray {

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

    static int[] rotateArrayLeft(int[] arr, int n) {
        // Write your code here.\
        int temp = arr[0]; // storing the first element of array in a variable
        for (int i = 0; i < n - 1; i++) 
        {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
        return arr;

    }
    static int[] rotateArrayLeftKTimes(int[] arr, int n, int k) {
        // Write your code here.\
        while(k>0)
        {
        int temp = arr[0]; // storing the first element of array in a variable
        for (int i = 0; i < n - 1; i++) 
        {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
        k--;
    }
        return arr;

    }

    static int[] rotateArrayRight(int[] arr, int n) {
        // Write your code here.\
        int temp = arr[n-1];
        for (int i = n-1; i > 0; i--) 
        {
            arr[i] = arr[i-1];
        }
        arr[0] = temp ;
        return arr;

    }
    static int[] rotateArrayRightKtimes(int[] arr, int n,int k) {
        // Write your code here.\
        while(k>0)
        {
        int temp = arr[n-1];
        for (int i = n-1; i > 0; i--) 
        {
            arr[i] = arr[i-1];
        }
        arr[0] = temp ;
        k--;
        }
        return arr;

    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = input();
        // rotateArrayLeft(arr, arr.length);
        System.out.println("enter the number of rotation");
        int k = sc.nextInt();

        // rotateArrayRightKtimes(arr, arr.length,k);
        rotateArrayLeftKTimes(arr, arr.length, k);
        print(arr);

    }
}
