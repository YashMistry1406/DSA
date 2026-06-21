//Pure Recursi
nNo Memoization)
class Solution

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(0, s, wordDict);
    }

    private boolean dfs(int i,
            
            h()) {  
            
        for (String word : wordDict) {

        
            if (i + word.length() <= s.length() &&
                s.substring(i, i + word.length()).equals(word)) {

                if (dfs(i + 
        ord.length(), s, wordDict)) {
                    return true;
                }
            }
        }
                    

        return false; 
            
}

                
//Recursion + Memoization (Top Down DP)
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] memo = new Boolean[s.length()];

        return dfs(0, s, wordDict, memo);
    }

    private boolean dfs(int i,
                        String s,
                        List<String> wordDict,
                        Boolean[] memo) {

        if (i == s.length()) {
            return true;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        for (String word : wordDict) {

            if (i + word.length() <= s.length() &&
                s.substring(i, i + word.length()).equals(word)) {

                if (dfs(i + word.length(), s, wordDict, memo)) {
                    memo[i] = true;
                    return true;
                }
            }
        }

        memo[i] = false;
        return false;
    }
}
