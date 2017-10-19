/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/description/
 */

/* using extra memory */
class Solution1 {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length; // row 
        int n = grid[0].length; // column
        
        int[][] out = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i ++)
        {
            for (int j = 1; j <= n; j ++)
            {
                if (i == 1 || j == 1)
                    out[i][j] = Math.max(out[i - 1][j], out[i][j - 1]) + grid[i - 1][j - 1];
                else
                    out[i][j] = Math.min(out[i - 1][j], out[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        
        return out[m][n];
    }
}

/* without extra memory */
class Solution2{
    public int minPathSum(int[][] grid) {
        
        int m = grid.length; // row 
        int n = grid[0].length; // column
        
        for (int i = 0; i < m; i ++)
        {
            for (int j = 0; j < n; j ++)
            {  
                if (i == 0 && j == 0)
                    grid[i][j] = grid[i][j];
                else if (i == 0)
                    grid[i][j] += grid[i][j - 1];
                else if (j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[m - 1][n - 1];
    }
}