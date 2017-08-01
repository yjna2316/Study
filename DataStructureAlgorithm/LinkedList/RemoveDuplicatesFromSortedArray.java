/*
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
 */

 /* solution 1*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = (nums.length > 0) ? 1 : 0;
        for (int num : nums) 
            if (num > nums[j - 1]) nums[j++] = num;
        return j;
    }
}
