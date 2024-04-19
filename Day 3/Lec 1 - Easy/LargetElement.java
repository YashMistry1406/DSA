import java.util.Scanner;

public class LargetElement {


    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++)
        {
            if (arr[i]>max)
            {
                max=arr[i];
            }
        }

        return max;
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

        Scanner sc  = new Scanner(System.in);
        int[] arr = input();
        largestElement(arr,arr.length);
    }

}
