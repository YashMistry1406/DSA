import java.util.*;

/**
 * Secondmax
 */
public class SecondLargest {
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;

        for(int i = 0; i < a.length; i++)
        {
            if(a[i]>largest)
            {
                second_largest=largest;
                largest=a[i];
                
            }
            else if(a[i]>second_largest && a[i]!=largest)
            {
                second_largest=a[i];
            }
        
            if(a[i]<smallest)
            {
                second_smallest=smallest;
                smallest=a[i];
                
            }
            else if(a[i]<second_smallest && a[i]!=smallest)
            {
                second_smallest=a[i];
                
            }
            
        }

        int [] temp = new int[2];
        temp[0]=second_largest;
        temp[1]=second_smallest;
        System.out.println(second_largest+"____"+second_smallest);
        return temp;
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
        arr = getSecondOrderElements(arr.length, arr);
        print(arr);
   }
}