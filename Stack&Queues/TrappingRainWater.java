import java.util.*;

public class TrappingRainWater {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;
        int ans = 0;
        while (l < r) {
            if (arr[l] <= arr[r]) {
                if (lmax > arr[l])
                    ans += lmax - arr[l];
                else
                    lmax = arr[l];
                l += 1;
            } else {
                if (rmax > arr[r])
                    ans += rmax - arr[r];
                else
                    rmax = arr[r];
                r -= 1;
            }
        }
        
        // System.out.println(ans);

    }
}
