/** 
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;     // row 
        int n = obstacleGrid[0].length;  // col
        
        for (int i = 0; i < m; i ++)
        {
            for (int j = 0; j < n; j ++)
            {
               // if obstacle, then the number of ways to pass this is none (zero)
               if (obstacleGrid[i][j] == 1)
                   obstacleGrid[i][j] = 0;
               else if (i == 0 && j == 0)
                   obstacleGrid[i][j] = 1;
               else if (i == 0)
                   obstacleGrid[i][j] = obstacleGrid[i][j - 1];
               else if (j == 0)
                   obstacleGrid[i][j] = obstacleGrid[i - 1][j];
               else 
                   obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];      
            }
        }
        
        return obstacleGrid[m - 1][n - 1];
    }
}