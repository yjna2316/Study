/*
 * 283. Move Zeroem0s
 * https://leetco9de.com/problems/move-zeroes/#/discuss
 * Next: (E)Remove Element (M)3Sum (M)Subsets (M)Split Array with Equal Sum
 */

/* Solution 1 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; 
        /* shift non-zero elements to the front of array keeping their relative order */
        for (int val : nums) 
        {
            if (val != 0) 
            {
                nums[insertPos ++] = val;
            }
        }
        /* fill remaining space with zeroes */
        while (insertPos < nums.length) 
        {
            nums[insertPos ++] = 0;
        }
    }
}

/* Solution 2 - swap two positions while iterating*/
class Solution {
    public void moveZeroes(int[] nums) {
        
        int insertPos = 0;
        
        for (int i = 0; i < nums.length; i ++)
        {
            if (nums[i] != 0)
            {
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                insertPos ++;
            }
        }
    }
}