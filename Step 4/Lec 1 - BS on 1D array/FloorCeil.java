import java.util.*;

/**
 * FloorCeil
 */
public class FloorCeil {

    public static int getCeil(int[] a, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= x) {
                ans = a[mid];
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int getFloor(int[] a, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] <= x) {
                ans = a[mid];
                low = mid + 1;
                
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = getFloor(arr, n, x);
        int c = getCeil(arr, n, x);
        return new int[] {f, c};
    }

}