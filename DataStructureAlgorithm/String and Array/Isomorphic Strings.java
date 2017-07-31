/*
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/description/
 */

 /* Solution 1 - using hashmap (22ms) */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char left = s.charAt(i), right = t.charAt(i);
            if (!map.containsKey(left)) {
                if (map.containsValue(right)) return false;
                map.put(left, right);
            } else {
                if (!map.get(left).equals(right)) return false;
            }
        }
        return true;
    }
}

/* Solution 2 - without map (6ms) */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha_S = new int[256];
        int[] alpha_T = new int[256];
        for (int i = 0; i < s.length(); i ++) {
            char left = s.charAt(i), right = t.charAt(i);
            if (alpha_S[left] == 0 && alpha_T[right] == 0) alpha_S[left] = alpha_T[right] = i + 1; 
            if (alpha_S[left] != alpha_T[right] )  return false;   
        }
        return true;
    }
}
