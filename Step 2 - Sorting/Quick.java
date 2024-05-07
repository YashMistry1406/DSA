import java.util.*;

/**
 * Quick
 */
public class Quick {

    static List<Integer> input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array length");
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        System.out.println("Enter array element");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        return arr;
    }

    static void print(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
        System.out.println();

    }

    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }
            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }

            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;

    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here.
        qs(arr,0, arr.size() - 1);
        return arr;
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr = input();
        quickSort(arr);
        print(arr);

    }
}