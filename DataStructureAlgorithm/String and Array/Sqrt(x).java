/*
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/discuss/
 */

/* 
 * Using Binary Search not to cause time limit error 
 * Be careful of causing overflow, or time limit error occurs -> instead of using M * M == x, used M == x / M
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int L = 1, R = x;
        while (L < R) {
            int M = (L + R) / 2;
            if (M == x / M) return M; 
            if (M < x / M) L = M + 1;
            else R = M;
        }
        return L - 1;
    }
}