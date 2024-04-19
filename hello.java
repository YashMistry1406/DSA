import java.util.*;

/**
 * hello
 */
public class hello {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("Enter the length");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 0;
            if (hash.containsKey(key)) {
                freq = hash.get(key); // fetching from the map
                freq++;
                hash.put(key, freq); // inserting into the map
            } 
            else {
                hash.put(key, 1);
            }
        }

        hash.forEach((k, v) -> {

        System.out.println(k+" -> "+ v);
        });

        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;
       for(Map.Entry<Integer,Integer> entry: hash.entrySet())
        {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = element;
                minFreq = count;
            }
        }

        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);

    }
}
