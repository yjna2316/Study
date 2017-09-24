/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/discuss/
 */

/** 
 * Solution 1
 * From the fact that palindrome number is symmetric, reversed number and non-reversed number should be the same.
 * But reversed number might overflow.
 */  
public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reversed = 0, original = x;
        while (original > 0) {
            reversed = reversed * 10 + (original % 10);
            original /= 10;
        }
        return reversed == x;
    }
}

/**
 * Solution 2 
 * To avoid overflow, compare from two ends and chop off on digit from both ends.
 */
 public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) { //  x >= 10말고 x > 0으로 해야 10021 경우 커버 가능
            if (x / div != x % 10) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}


