/** 
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/description/
 */

public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int b1 = (i < 0) ? 0 : a.charAt(i--) - '0';
            int b2 = (j < 0) ? 0 : b.charAt(j--) - '0';
            int sum = b1 + b2 + carry;
            carry = sum / 2;
            result.append(sum % 2);
        }
        return result.reverse().toString();
    }
}