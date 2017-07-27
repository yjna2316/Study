/*
 * https://leetcode.com/problems/word-pattern/tabs/discuss
 * 290. Word Pattern
 */

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        System.out.println(Arrays.toString(word));
        if (pattern.length() != word.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i ++) 
        {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) 
            {
                if (map.containsValue(word[i])) return false;
                map.put(c, word[i]);
            }
            else 
            {
                if (!map.get(c).equals(word[i])) return false; 
            }  
        }
        return true;
    }
}