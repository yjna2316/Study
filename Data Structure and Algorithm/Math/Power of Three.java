/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/description/
 * Next: (E)Power of Two (E)Power of Four 
 */

/* Solution - Iteratively */
class Solution1 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}

/* Solution - Recursively */
class Solution2 {
    public boolean isPowerOfThree(int n) {
       return n > 0 && (n == 1 || n % 3 == 0 && isPowerOfThree(n / 3));  
    }
}