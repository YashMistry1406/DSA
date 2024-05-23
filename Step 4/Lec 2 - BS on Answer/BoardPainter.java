import java.util.*;

/**
 * BoardPainter
 */
public class BoardPainter {

    public static int countPartition(ArrayList<Integer> arr, int maxSum) {
        int n = arr.size();
        int partition = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr.get(i) <= maxSum) {
                sum += arr.get(i);
            }
            else {
                partition ++;
                sum = arr.get(i);
            }
        }
        return partition;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        // Write your code here.
        int low = boards.get(0);
        int high = 0;
        // find maximum and summation:
        for (int i = 0; i < boards.size(); i++) {
            low = Math.max(low, boards.get(i));
            high += boards.get(i);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartition(boards, mid);
            if (partitions > k) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;
    }
}
