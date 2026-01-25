import java.util.*;

/**
 * PalindromNumber
 */
public class PalindromNumber {

    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);

        System.out.println("Reverse a number");
        int num = sc.nextInt();


        int temp = num;
        int rev = 0;
        while(num>0)
        {
           rev = (rev*10)+(num%10) ;
           num = num /10;
        }

        System.out.println((rev==temp)? "Yes it's a palindrome": "no it's not a palindrome");

    }
}
