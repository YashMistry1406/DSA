/*
 * Main Loop Starts at (0,0)
                                                    |
                                          DFS(0, 0, idx=0) -> ['A']
                                       🟢 MATCHES 'A' (idx 0 == 'A')
                                         Set board[0][0] = '#'
        ____________________________________________|____________________________________________
       |                                            |                                            |
   DOWN -> (1,0)                                 UP -> (-1,0)                                RIGHT -> (0,1)
  DFS(1, 0, idx=1)                             DFS(-1, 0, idx=1)                           DFS(0, 1, idx=1)
    -> ['C']                                     -> Out of Bounds                            -> ['B']
 🛑 FAILED: 'C' != 'B'                        🛑 FAILED: i < 0                            🟢 MATCHES 'B' (idx 1 == 'B')
   Returns: false                               Returns: false                              Set board[0][1] = '#'
                                                                                                 |
                                       __________________________________________________________|__________________________________________________________
                                      |                             |                            |                                                          |
                                  DOWN -> (1,1)                  UP -> (-1,1)                RIGHT -> (0,2)                                             LEFT -> (0,0)
                                 DFS(1, 1, idx=2)              DFS(-1, 1, idx=2)            DFS(0, 2, idx=2)                                           DFS(0, 0, idx=2)
                                   -> ['D']                      -> Out of Bounds             -> Out of Bounds                                           -> ['#']
                                🛑 FAILED: 'D' != 'C'         🛑 FAILED: i < 0             🛑 FAILED: j >= cols                                       🛑 FAILED: '#' != 'C'
                                  Returns: false                Returns: false               Returns: false                                             (Prevents infinite loop!)
                                                                                                                                                        Returns: false
 * */
class Solution
{
    public boolean exist(char[][] board, String word)
    {
        // Get number of rows
        int rows = board.length;
        // Get number of columns
        int cols = board[0].length;

        // Iterate over all cells
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                // Start DFS if first letter matches
                if (dfs(board, word, i, j, 0))
                {
                    return true;
                }
            }
        }
        // No match found
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx)
    {
        // If word is completely found
        if (idx == word.length())
            return true;

        // Boundary and mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx))
        {
            return false;
        }

        // Store character and mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore in all four directions
        boolean found = dfs(board, word, i + 1, j, idx + 1) || dfs(board, word, i - 1, j, idx + 1)
                || dfs(board, word, i, j + 1, idx + 1) || dfs(board, word, i, j - 1, idx + 1);

        // Restore character
        board[i][j] = temp;

        return found;
    }
}

public class WordSearch
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(sol.exist(board, "ABCCED")); // true
        System.out.println(sol.exist(board, "SEE")); // true
        System.out.println(sol.exist(board, "ABCB")); // false
    }
}
