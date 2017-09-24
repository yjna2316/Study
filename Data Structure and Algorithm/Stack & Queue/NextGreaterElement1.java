/*
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/#/description
 */

/* using HashMap */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i + 1);
        }
        for (int i = 0; i < findNums.length; i ++) {
            int position = map.get(findNums[i]); 
            while (position < nums.length && findNums[i] > nums[position]) {
                position ++;
            } 
            findNums[i] = (position < nums.length) ? nums[position] : -1;
        }
        return findNums;
    }
} 
