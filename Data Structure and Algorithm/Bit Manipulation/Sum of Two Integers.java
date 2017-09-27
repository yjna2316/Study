/*
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/discuss/
 * Next: (M)Single Number 3 (M)Integer Replacement (E)Number Complement
 */
 
class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        
        int sum = 0, carry = 0;
        while (b != 0) 
        {
            sum = a ^ b;  
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }
}