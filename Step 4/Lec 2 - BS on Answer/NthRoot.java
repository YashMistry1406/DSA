/**
 * NthRoot
 * 
 * 
 */
public class NthRoot {

    public int root(int n, int m)
    {
        // code here
        int low = 0;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sq = (int) Math.pow(mid,n);
            
            if (sq == m)
                return mid;
            else if (sq < m) {
                low = mid + 1;
            }
            else high = mid - 1 ; 
        }
        return -1;
    }
}