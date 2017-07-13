/* 
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int L = 0, R = numbers.length - 1;
        while (L < R) {
            if (numbers[L] + numbers[R] < target) L ++;
            else if (numbers[L] + numbers[R] > target) R--;
            else break;
        }
        return new int[]{L + 1, R + 1};
    }
}