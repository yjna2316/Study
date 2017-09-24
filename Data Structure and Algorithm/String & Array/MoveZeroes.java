/*
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/#/discuss
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; 
        /* shift non-zero elements to the front of array keeping their relative order */
        for (int num : nums) {
            if (num != 0) nums[insertPos ++] = x;
        }
        /* fill remaining space with zeroes */
        while (insertPos < nums.length) {
            nums[insertPos ++] = 0;
        }
    }
}