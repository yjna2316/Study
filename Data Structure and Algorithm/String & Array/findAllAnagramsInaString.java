/*
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/#/discuss
 * 438. Find All Anagrams in a String
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p == null || s == null || s.length() < p.length()) return list;
        int[] hash = new int[26];
        // record each character in hash
        for (char c : p.toCharArray()) {
            hash[c - 'a'] ++;
        }
        int counter = p.length();  // check whether the substring is valid
        int left = 0, right = 0;
        while (right < s.length()) {
            if (hash[right - 'a']-- >= 1)  counter --;
            right ++;
            if (counter == 0) list.add(left);
            if (right - left == p.length()) {
                if (hash[left - 'a'] ++ >= 0) counter ++;
                left ++;
                
            }
        }
        return list;
    }
}