import java.util.*;

/**
 * MoveZeroToEnd
 */
public class MoveZeroToEnd
{

    static int[] input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array length");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array element");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static void print(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "-");
        }

    }

    // public static int[] moveZeros(int n, int []arr) {
    // // Write your code here.

    // int i = 0;
    // int j = arr.length-1 ;

    // while(i<j)
    // {
    // if(arr[i]==0 && arr[j]!=0)
    // {
    // arr[i]= arr[j];
    // arr[j] = 0;
    // j--;
    // }
    // i++;
    // }
    // return arr ;
    // }
    public static void solve(int[] nums)
    {
        // Pointer to the first zero
        int j = -1;

        // Find the first zero
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                j = i;
                break;
            }
        }

        // If no zero found, return
        if (j == -1)
            return;

        // Start from the next index of first zero
        for (int i = j + 1; i < nums.length; i++)
        {
            // If current element is non-zero
            if (nums[i] != 0)
            {
                // Swap with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j to next zero
                j++;
            }
        }
    }

    public static int[] moveZeros(int n, int[] arr)
    {
        // Write your code here.

        int i = 0;

        while (i < arr.length - 1)
        {
            if (arr[i] == 0)
            {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            i++;
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int[] arr = input();
        moveZeros(arr.length, arr);
        print(arr);
    }
}
