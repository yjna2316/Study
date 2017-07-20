/*
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/#/description
 */

 /* solution 1 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int x : nums) {
            if (x == 0) {
                max = (max > count) ? max : count;
                count = 0;
            } else{
                count ++;
            }          
        }
        return (max > count) ? max : count; //  In case, the array is only consists of 1 so that max value did not update ex.1111 
    }
}

/* solution 2 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int x : nums) {
            count = (x == 0) ? 0 : count + 1;
            max = (max > count) ? max : count;
        }
        return max;
    }
}

/* solution 3 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int x : nums) {
            max = Math.max(max, count = (x == 0) ? 0 : count + 1);      
        }
        return max; 
    }
}