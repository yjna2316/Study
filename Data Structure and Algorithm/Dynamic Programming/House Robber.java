/** 
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 * (M)Maximum Product Subarray (M)House Robber II (E)Paint House (E)Paint Fence (M)House Robber III
 */

class Solution {
    public int rob(int[] nums) {
         
        if (nums.length == 0) 
            return 0;
        
        // d[n] := max amount of money by visiting from 1th to nth house.
        int[] d = new int[nums.length + 1];
        d[0] = 0;
        d[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i ++) 
        {
            d[i] = (d[i - 1] > nums[i - 1] + d[i - 2]) ? d[i - 1] : nums[i - 1] + d[i - 2]; 
        }
        return d[nums.length];
    }
    
}
