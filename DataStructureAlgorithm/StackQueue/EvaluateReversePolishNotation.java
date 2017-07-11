/*
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
 */

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String token : tokens) {
            if (token.equals("/") || token.equals("+") || token.equals("-") || token.equals("*")) {
                calculate(token, s);
            } else {
              s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
    private void calculate(String token, Stack<Integer> s) {
        int n2 = s.pop();
        int n1 = s.pop();
        if (token.equals("/")) s.push(n1 / n2);
        else if (token.equals("*")) s.push(n1 * n2);
        else if (token.equals("+")) s.push(n1 + n2);
        else s.push(n1 - n2);
    }
}