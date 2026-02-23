import java.util.*;

public class test
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the aray elements");
        for (int i = 0; i < n; i++)
        {
            arr.add(sc.nextInt());
        }
        arr = bubbleSort(arr);
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.print(arr.get(i) + "-->");
        }

    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arr)
    {

        for (int i = 0; i < arr.size(); i++)
        {
            for (int j = i + 1; j < arr.size(); j++)
            {
                int mini = i;
                if (arr.get(j) < arr.get(i))
                {
                    mini = arr.get(j);

                }
                arr.set(j, arr.get(i));
                arr.set(i, mini);
            }
        }
        return arr;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr)
    {

        int n = arr.size();
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = 0; j <= i - 1; j++)
            {
                if (arr.get(j) > arr.get(j + 1))
                {
                    int temp = arr.get(j + 1);
                    arr.set(j + 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        return arr;
    }

}
