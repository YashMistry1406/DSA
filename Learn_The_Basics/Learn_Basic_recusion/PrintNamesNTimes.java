import java.util.*;

/**
 * PrintNamesNTimes
 */
public class PrintNamesNTimes {

    public static void printNTimes(String name, int n)
    {
        if(n>0) 
        {
            System.out.print(name+" ");
            n=n-1;
            printNTimes(name, n);
        }
        else System.out.println();return;

    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a A name to print");
        String name = sc.next();

        System.out.println("Enter the number of time to print it ");
        int n = sc.nextInt();

        printNTimes(name,n);


    }
    
}
