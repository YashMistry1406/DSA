import java.util.*;

/**
 * PrintToN
 */
public class PrintToN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("print to n");
        int n = sc.nextInt();

        printNumbers(1,n);


    }

    public static void printNumbers(int current, int n) {
        // Base case: if current exceeds n, stop recursion
        if (current > n)
            return;

        // Recursive call with next number
        printNumbers(current + 1, n);

        // Print current number during backtracking
        System.out.print(current + " ");
    }


	private static void printtoN(int i,int n) {
		//

        if(i==n)
        {
            System.out.println(i);
            return;
        }
        else System.out.print(i+","); printtoN(i+1, n);
	}
}
