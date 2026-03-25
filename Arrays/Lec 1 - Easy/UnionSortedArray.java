import java.util.*;


/**
 * UnionSortedArray
 */
public class UnionSortedArray {

    
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
      int n = a.length;
      int m = b.length;
       int i = 0, j = 0; // pointers
  ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
  while (i < n && j < m) {
    if (a[i] <= b[j]) // Case 1 and 2
    {
      if ( Union.size() ==0 || Union.get(Union.size()-1) != a[i])
        Union.add(a[i]);
      i++;
    } else // case 3
    {
      if (Union.size() ==0 || Union.get(Union.size()-1) != b[j])
        Union.add(b[j]);
      j++;
    }
  }
  while (i < n) // IF any element left in a
  {
    if (Union.get(Union.size()-1) != a[i])
      Union.add(a[i]);
    i++;
  }
  while (j < m) // If any elements left in b
  {
    if (Union.get(Union.size()-1) != b[j])
      Union.add(b[j]);
    j++;
  }
  return Union;
    }


    
}