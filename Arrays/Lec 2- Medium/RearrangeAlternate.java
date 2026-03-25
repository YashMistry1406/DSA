import java.util.*;;

/**
 * RearrangeAlternate
 */
public class RearrangeAlternate {

    public static int[] alternateNumbers(int []a) {
        // Write your code here.
        int n = a.length;
        int [] arr = new int[a.length];
        int pos = 0 ; 
        int neg = 1 ;
        for(int i = 0 ; i < n ; i ++)
        {
            if(a[i]< 0 )
            {
                arr[neg] = a[i];
                neg+=2;
            }
            else{
                arr[pos] = a[i];
                pos+=2;
            }
        }
        return arr;
    }
}
