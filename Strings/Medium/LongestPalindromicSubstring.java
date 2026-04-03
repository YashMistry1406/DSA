package Strings.Medium;

class ManachersAlgo {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        // 1. Preprocess: "aba" -> "^#a#b#a#$"
        // ^ and $ are boundaries to avoid bounds checking in the loop
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");
        String t = sb.toString();

        int n = t.length();
        int[] d = new int[n]; // Array to store radii
        int l = 0, r = 0; // Rightmost palindrome boundaries

        int maxRadius = 0;
        int centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            // 2. Use the mirror property
            int mirror = l + (r - i);
            if (i < r) {
                d[i] = Math.min(r - i, d[mirror]);
            }

            // 3. Attempt to expand around center i
            while (t.charAt(i + (1 + d[i])) == t.charAt(i - (1 + d[i]))) {
                d[i]++;
            }

            // 4. Update boundaries if we found a palindrome further to the
            // right
            if (i + d[i] > r) {
                l = i - d[i];
                r = i + d[i];
            }

            // Keep track of the longest one found
            if (d[i] > maxRadius) {
                maxRadius = d[i];
                centerIndex = i;
            }
        }

        // 5. Extract the original substring
        // The start index in original string is (centerIndex - maxRadius) / 2
        int start = (centerIndex - maxRadius) / 2;
        return s.substring(start, start + maxRadius);
    }
}

// O(n^2) --> expand left and right of a center character in the string and keep
// checking for palindrome
// 2 loops becuase 1 for odd length palindrome and 1 for even length palindrome
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int bestLen = 0;
        String bestS = "";
        int n = s.length();

        for (int mid = 0; mid < n; mid++) {
            for (int x = 0; mid - x >= 0 && mid + x < n; x++) {
                if (s.charAt(mid - x) != s.charAt(mid + x)) {
                    break;
                }
                int len = 2 * x + 1;
                if (len > bestLen) {
                    bestLen = len;
                    bestS = s.substring(mid - x, mid + x + 1);
                }
            }
        }

        for (int mid = 0; mid < n - 1; mid++) {
            for (int x = 1; mid - x + 1 >= 0 && mid + x < n; x++) {
                if (s.charAt(mid - x + 1) != s.charAt(mid + x)) {
                    break;
                }
                int len = 2 * x;
                if (len > bestLen) {
                    bestLen = len;
                    bestS = s.substring(mid - x + 1, mid + x + 1);
                }
            }
        }

        return bestS;
    }

    public static void main(String[] args) {

    }
}

class Solution {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String longestPalindrome(String s) {

        String ans = "";

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);

                if (isPalindrome(sub) && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }
        return ans;
    }
}
