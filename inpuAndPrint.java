import java.util.*;


public class inpuAndPrint {

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

    
}
