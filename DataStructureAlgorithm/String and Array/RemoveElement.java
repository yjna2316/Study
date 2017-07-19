/*
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/#/description
 */

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int x : nums) {
            if (x != val) nums[i++] = x;
        }
        return i;
    }
}
