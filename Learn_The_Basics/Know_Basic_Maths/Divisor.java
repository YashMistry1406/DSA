import java.util.*;
/**
 * Divisor
 */
public class Divisor {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("enter a number to find all the divisor");
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<Integer>();
        int i = 1;
        while(i<=n/i)
        {
            if(n%i==0)
            {
                arr.add(i);
                if(n/i!=i)
                arr.add(n/i);
            }
            i++;
        }

        Collections.sort(arr);
        for (int ele : arr) {
            System.out.println("Array elements--> " +ele);
            
        }
    }
}
