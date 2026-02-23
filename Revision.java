import java.util.*;

/**
 * Revision
 */
public class Revision
{

    static void RotateAnArray(int[] arr)
    {
        int temp = arr[0];
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
    }

    static void RotateLeftByK(int[] arr, int k)
    {
        while (k > 0)
        {
            int temp = arr[0];
            int n = arr.length;
            for (int i = 0; i < n - 1; i++)
            {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = temp;
            k--;
        }
        print(arr);
    }

    static void print(int[] arr)
    {
        System.out.println("output array");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);

        }
    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value of K");
        int k = sc.nextInt();
        RotateLeftByK(arr, k);

    }
}
