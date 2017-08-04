/*
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/discuss/
 */

public class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int c1 = (i < 0) ? 0 : num1.charAt(i--) - '0';
            int c2 = (j < 0) ? 0 : num2.charAt(j--) - '0';
            result.insert(0, (carry + c1 + c2) % 10);
            carry = (carry + c1 + c2) / 10;
        }
        return result.toString();
    }
}