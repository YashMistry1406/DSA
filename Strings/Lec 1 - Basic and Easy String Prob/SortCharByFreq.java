import java.util.*;

/*import java.util.Map.Entry;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        Map<Character, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        String str = "";
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());

            for (int i = 0; i < entry.getValue(); i++) {
                str = str + entry.getKey();
            }
        }
        return str;
    }
}
/**
 * SortCharByFreq
 */
public class SortCharByFreq {
    public List<Character> frequencySort(String s) {
        // Array to hold frequency and character for 'a' to 'z'
        Pair[] freq = new Pair[26];

        // Initialize the frequency array
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char) (i + 'a'));
        }

        // Count frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        // Sort array by frequency descending, then by character ascending
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        // Collect characters with non-zero frequency into result list
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0)
                result.add(p.ch);
        }

        // Return the final list
        return result;

    }

    class Pair {
        int freq;
        char ch;

        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }
}
