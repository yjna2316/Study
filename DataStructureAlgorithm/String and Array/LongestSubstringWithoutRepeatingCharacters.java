/*
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/discuss
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0, max = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && len >= i - map.get(c)) {  // if duplicates
                max = (max > len) ? max : len;  // max update
                len = i - map.get(c) - 1;  // new length
            }
            map.put(c, i);
            len ++;            
        }
        return (max > len) ? max : len; 
    }
}