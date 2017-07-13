/* 
 * 167. Two Sum II 
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int L = 0, R = numbers.length - 1;
        while (numbers[L] + numbers[R] != target) {
            if (numbers[L] + numbers[R] < target) L ++; 
            else R --;
        }
        return new int[]{L + 1, R + 1};
    }
}