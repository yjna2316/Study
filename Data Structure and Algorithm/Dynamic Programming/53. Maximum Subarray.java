/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */

/* Greedy - update new sum and maxSum every index of an array */ 
class Solution1 {
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0], sum = nums[0];
        
        for (int i = 1; i < nums.length; i ++)
        {
            sum = Math.max(sum + nums[i], nums[i]); // update new sum with adding new value
            maxSum = Math.max(sum, maxSum);         // update answer when new value is added, get contiguous max sum
        }
        
        return maxSum;
    }
}

/* DP - memo in an extra space from bottom to top, get answer from previous value and new sum */
class Solution2 {
    public int maxSubArray(int[] nums) {
        
        int[] d = new int[nums.length]; // d[n] := the maximum sum of subarray ending with nums[i]
        d[0] = nums[0];
       
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i ++)
        {
            d[i] = Math.max(d[i - 1] + nums[i], nums[i]);
            max = Math.max(d[i], max); 
        }
          
        return max;
    }
}
