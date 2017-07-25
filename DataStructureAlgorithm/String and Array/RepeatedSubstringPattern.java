/* 
 * https://leetcode.com/problems/repeated-substring-pattern/#/description
 * 459. Repeated Substring Pattern
 */

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int gap = 1, len = s.length();
        while (gap <= (len / 2)) 
        {
            while (len % gap != 0)  // to avoid runtime error - out of index  
            {
                gap ++;
                if (gap > (len / 2)) return false;
            }
            int i = 1;
            String temp = s.substring(0, gap);
            while (temp.equals(s.substring(gap * i, gap * (i + 1)))) 
            {
                if (gap * (i + 1) == len) return true;
                i ++;
            }
            gap ++;
        }
        return false;
    }
}