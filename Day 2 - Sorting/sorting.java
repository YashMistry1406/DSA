import java.util.Scanner;

/**
 *
 * sorting
 * Selection Sort
 * Bubble sort
 *
 */
public class sorting {

    static int[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array length");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array element");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * selction sort
     */
    static void Selection() {

        int arr[] = input();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) // 64 25 12 22 11
        {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
                int temp = arr[mini];
                arr[mini] = arr[i];
                arr[i] = temp;

            }
        }
        print(arr);

    }

    /**
     * @return
     * Bubble Sort 
     */
    static void Bubble()
    {
        int arr[] = input();
        int n = arr.length;

        for(int i = 0; i<n-1;i++)
        {
            for(int j = 0 ; j< n-i-1;j++)
            {
                if (arr[j]> arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        print(arr);
    }

    static void insertion()
    {

        int arr[] =input();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            int j = i;
            while(j>0 && arr[j-1]>arr[j])
            {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        print(arr);
    }

    public static void main(String[] args) {

        //Selection();
        Bubble();
        insertion();

    }
}
