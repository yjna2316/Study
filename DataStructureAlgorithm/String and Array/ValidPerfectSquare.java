/*
 * https://leetcode.com/problems/valid-perfect-square/tabs/discuss
 * 367. Valid Perfect Square
 */

public class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > num) {
                right = (int)mid - 1; 
            } else if (mid * mid < num) {
                left = (int)mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
public class Solution {
    public boolean isPerfectSquare(int num) {
        for (int x = 1; x <= num / 2; x ++) 
        {
            if (num == x * x) return true;
        }
        return num == 1;
    }
}