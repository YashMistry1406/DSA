import java.util.*;;

/**
 * SuperiorElement
 */
public class SuperiorElement {

    
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        int n = a.length;
        List<Integer> arr = new ArrayList<>();
        int maxi = a[n-1];
        arr.add(maxi);
        for(int i = n-1 ; i >=0 ; i--)
        {
            

             if(a[i]>maxi)
            {
                arr.add(a[i]);
                maxi = a[i];
            }
            else continue;

        }
        return arr;
    }
}