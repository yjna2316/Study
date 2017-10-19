/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/discuss/
 */

class Solution {
    public int numSquares(int n) {
        
        /**
         * d[i] := 합이 i가 되는 최소 square numbers의 갯수 
         */
        int[] d = new int[n + 1];
     
        for (int i = 1; i <= n; i ++)
        {
            // d[i]를 초기화. square# 1를 포함하는 경우 
            d[i] = 1 + d[i - 1]; 
            
            // square numbers를 순서대로 넣으면서 d[i] update
            for (int k = 2; k <= Math.sqrt(i); k ++)
            {
                d[i] = Math.min(d[i], 1 + d[i - k * k]);
            }
        }
        
        return d[n];
    }
}