/*
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/discuss
 */

/* Solution 1 - Sliding Window using int[128] for ASCII 128 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int[] index = new int[128];
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j ++) {
            i = Math.max(index[s.charAt(j)], i);
            max = Math.max(max, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return max;
    }
}

/* Solution 2 - Siding Window using HashMap */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {  // if duplicates
                j = Math.max(j , map.get(c) + 1); 
            }
            map.put(c, i);
            max = Math.max(max , i - j + 1);
        }
        return max; 
    }
}

/* Solution 3 - boolean[256] for Extended ASCII */
 public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
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