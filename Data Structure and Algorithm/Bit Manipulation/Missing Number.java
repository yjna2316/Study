/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/description/
 * Next: (E)Single Number (M)Find the Duplicate Number
 */

import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        // sort
        Arrays.sort(nums);
        // diff > 1 return a[i] + 1;
        for (int i = 1; i < nums.length; i ++)
        {
            if (nums[i] - nums[i - 1] > 1)
            {
                return nums[i] - 1;
            }
        }
        
        return (nums[0] != 0) ? 0 : nums[nums.length - 1] + 1;
        
    }
}