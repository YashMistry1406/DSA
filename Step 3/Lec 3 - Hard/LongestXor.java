import java.util.*;

/**
 * LongestXor
 */
public class LongestXor {

    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        int n = a.length;
        HashMap<Integer,Integer> xorhash = new HashMap<>();
        int xr = 0;

        xorhash.put(xr,1);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^k:
            int x = xr ^ b;

            // add the occurrence of xr^k
            // to the count:
            if (xorhash.containsKey(x)) {
                cnt += xorhash.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (xorhash.containsKey(xr)) {
                xorhash.put(xr, xorhash.get(xr) + 1);
            } else {
                xorhash.put(xr, 1);
            }
        }
        return cnt;
    }
}