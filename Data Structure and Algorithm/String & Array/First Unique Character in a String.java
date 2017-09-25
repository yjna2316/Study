/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * Next:  (E)Best Time to Buy and Sell Stock II
 */

class Solution {
    public int firstUniqChar(String s) {
        //  알파벳 출현 횟수 기록
        int[] count = new int[128];
        
        //  문자열 조회하면서 알파벳 출현 횟수 1씩 증가
        for (int i = 0; i < s.length(); i ++)
        {
            count[s.charAt(i)] ++;
        }
        
        for (int i = 0; i < s.length(); i ++)
        {
            if (count[s.charAt(i)] == 1)
                return i;
               
        }
        return -1;
    }
}