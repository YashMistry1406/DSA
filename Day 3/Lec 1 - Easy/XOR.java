import java.util.*;


/**
 * XOR
 */
public class XOR {

    public static int getSingleElement(int []arr){
        // Write your code here.
        int xor = 0;
        for(int i = 0 ; i < arr.length; i++)
        {
            xor ^= arr[i];
        }
        return xor;
    }
}