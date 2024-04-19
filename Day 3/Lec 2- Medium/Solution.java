import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.


        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i ; j < m ;j++)
            {
                int temp  = mat.get(i).get(j);
                mat.get(i).set(j,mat.get(j).get(i)) ;
                mat.get(j).set(i,temp);
            }

        }

      for(int i = 0 ; i < n ; i++)
        {
           Collections.reverse(mat.get(i));
        }
       

     }
    }
