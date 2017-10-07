/** 
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/description/
 * (H) Maximal Rectangle
 */
class Solution {
    public int maximalSquare(char[][] m) {
        
        if (m.length == 0) 
            return 0;
        
        int maxSide = 0;  // the maximum side of the square
        int row = m.length;
        int col = m[0].length;

        /**
         * d[i][j] represents the length of the square 
         * whose lower-right corner is located at (i, j)
         * dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) 
         */
        int[][] d = new int[row + 1][col + 1];
        
        for (int i = 1; i <= row; i ++) {
            for (int j = 1; j <= col; j ++) {
                if (m[i - 1][j - 1] == '1') {
                    d[i][j] = Math.min(d[i - 1][j], Math.min(d[i][j - 1], d[i - 1][j - 1])) + 1;
                    maxSide = (maxSide > d[i][j]) ? maxSide : d[i][j];
                }
            }
        } 
        
        return maxSide * maxSide;
    }
}