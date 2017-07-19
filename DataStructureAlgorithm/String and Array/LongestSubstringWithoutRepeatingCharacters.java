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

/* 
 * Count array: use an array to count the occurrence of characters of a string,
 *              the indexes will be "characters". 
 */
 public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[128];//왜256?
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j ++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i ++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
}