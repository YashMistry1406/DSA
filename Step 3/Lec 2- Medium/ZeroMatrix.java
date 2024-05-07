import java.util.ArrayList;

import java.util.*;


/**
 * ZeroMatrix
 */
public class ZeroMatrix {

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // int[] row = new int[n]; --> matrix[..][0]
        // int[] col = new int[m]; --> matrix[0][..]
        int col0 = 1;

        for(int i = 0  ; i < n ; i++)
        {
            for(int j = 0 ; j< m; j++)
            {
                if(matrix.get(i).get(j) == 0)
                {
                    matrix.get(i).set(i, 0);
                }
                if(j!=0)
                {
                    matrix.get(0).set(j,0);
                }
                else 
                {
                    col0=0;
                }
            }
        }
        for(int i = 0 ; i < n;i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if (matrix.get(i).get(j) != 0) {
                    // check for col & row:
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }
}
