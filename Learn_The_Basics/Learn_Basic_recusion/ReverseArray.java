import java.util.*;

/**
 * ReverseArray
 */
public class ReverseArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();
        System.out.println("enter the length of an array");
        int n = sc.nextInt();
        System.out.println("Enter the arrray elements");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int p1 = 0;

        int p2 = arr.size() - 1;

        while (p1 < p2) {
            int temp = arr.get(p1);
            arr.set(p1, arr.get(p2));
            arr.set(p2, temp);

            p1++;
            p2--;
        }
        for (Integer integer : arr) {
            System.out.println(integer);

        }
    }
}
