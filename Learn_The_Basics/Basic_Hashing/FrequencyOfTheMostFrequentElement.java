import java.util.*;

/**
 * FrequencyOfTheMostFrequentElement
 */
public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();
        System.out.println("Enter the length of array");
        int n = sc.nextInt();
        System.out.println("Enter a array to check the lowest and highest count of element");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr.get(i))) {
                map.put(arr.get(i), 1);
            } else
                map.put(arr.get(i), map.get(arr.get(i)) + 1);

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key " + entry.getKey() + " Value " + entry.getValue());
        }

    }

}
