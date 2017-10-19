/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        
        /** 
         * d[m][n] := the number of unique paths to the from start to d[m][n] 
         */
        int[][] d = new int[m][n];

        for (int i = 0; i < m; i ++)
        {
            for (int j = 0; j < n; j ++)
            {
                if (i == 0 || j == 0)
                    d[i][j] = 1;
                else
                    d[i][j] = d[i][j - 1] + d[i - 1][j];  // sum of the paths from left and up to the d[i][j]
            }
        }
        
        return d[m - 1][n - 1];  
    }
}
 