import java.util.*;
public class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        S

        System.out.println("Enter number to count the digits");
        int num = sc.nextInt();

        int count = 0;
        while(num % 10 != 0)
        {
            count+=1;
            num=num/10;
        }
        System.out.println("the count"+count);
    }
    
}
