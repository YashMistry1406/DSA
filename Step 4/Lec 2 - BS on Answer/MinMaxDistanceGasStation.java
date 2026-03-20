import java.util.*;

class Pair
{
    double distance;
    int index;

    Pair(double distance, int index)
    {
        this.distance = distance;
        this.index = index;
    }
}

class Solution
{
    public double minimiseMaxDistance(int[] arr, int k)
    {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        // Priority queue (max-heap) to store the largest segment first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        // Add initial segments
        for (int i = 0; i < n - 1; i++)
        {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Place k additional gas stations
        for (int gasStations = 1; gasStations <= k; gasStations++)
        {
            Pair top = pq.poll();
            int idx = top.index;
            howMany[idx]++;

            double totalDist = arr[idx + 1] - arr[idx];
            double newDist = totalDist / (howMany[idx] + 1);
            pq.add(new Pair(newDist, idx));
        }

        // Return max distance after placing k stations
        return pq.peek().distance;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        Solution sol = new Solution();
        System.out.println("The answer is: " + sol.minimiseMaxDistance(arr, k));
    }
}
