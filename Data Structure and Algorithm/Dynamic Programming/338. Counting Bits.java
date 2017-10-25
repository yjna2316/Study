/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/ 
 */

/* Solution 1 */
class Solution {
    public int[] countBits(int num) {
        
        int[] d = new int[num + 1]; 
        
        for (int i = 1, pow = 1, startIndex = 0; i <= num; i ++)
        {
            if (i == pow) 
            {
                pow *= 2;
                startIndex = 0;
            } 
            
            d[i] = d[startIndex ++] + 1;
                     
        }
        return d;
    }
} 

/* Solution 2 */
class Solution {
    public int[] countBits(int num) {
        
        int[] d = new int[num + 1]; 
        
        for (int i = 1; i <= num; i ++)
        {
            d[i] = d[i / 2] + i % 2;
        }
        return d;
    }
} 

/* Solution 3 */
class Solution {
    public int[] countBits(int num) {
        
        int[] d = new int[num + 1]; 
        
        for (int i = 1; i <= num; i ++)
        {
            d[i] = d[i >> 1] + (i & 1);
        }
        return d;
    }
} 