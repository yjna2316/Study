/* 
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/#/description
 */

/* 
 * The idea is to create a size 26 int arrays as buckets for each letter in alphabet. 
 * It increments the bucket value with String s and decrement with string t. 
 * So if they are anagrams, all buckets should remain with initial value which is zero. 
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            alphabet[s.charAt(i) - 'a'] ++;
            alphabet[t.charAt(i) - 'a'] --;
        }
        for (int val : alphabet) {
            if(val != 0) return false;
        }
        return true;
    }
}
