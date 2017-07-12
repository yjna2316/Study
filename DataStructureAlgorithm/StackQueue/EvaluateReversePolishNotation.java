/*
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
 */

/* 
 * What if Exception in thread "main" java.lang.ArithmeticException: / by zero, 
 * how would you handle this?
 */
 
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> S = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" : 
                    S.push(S.pop() + S.pop()); 
                    break;
                case "-" : 
                    S.push(-S.pop() + S.pop()); 
                    break;
                case "*" : 
                    S.push(S.pop() * S.pop()); 
                    break;
                case "/" : 
                    int n2 = S.pop(), n1 = S.pop();
                    S.push(n1 / n2); 
                    break;
                default :
                    S.push(Integer.parseInt(token));
           }
        }
        return S.pop();
    }
}
