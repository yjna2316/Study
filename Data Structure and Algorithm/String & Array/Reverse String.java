/** 
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/description/
 * Next: (E)Reverse Vowels of a String (E)Reverse String II 
 */

class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i --)
        {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}