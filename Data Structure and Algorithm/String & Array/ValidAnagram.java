/* 
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/#/description
 * Next: (M)Group Anagrams (E)Palindrome Permutation (E)Find All Anagrams in a String 
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
        {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i ++) 
        {
            alphabet[s.charAt(i) - 'a'] ++;
            alphabet[t.charAt(i) - 'a'] --;
        }

        for (int val : alphabet) 
        {
            if(val != 0) return false;
        }

        return true;
    }
}
