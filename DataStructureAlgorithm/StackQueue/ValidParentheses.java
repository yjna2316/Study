/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/#/description
 */

/* using stack */
public class Solution {
    public boolean isValid(String str) {
        if (str.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}

/* using stack with toCharArray*/
public class Solution {
    public boolean isValid(String str) {
        if (str.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}

/* using stack with switch */
public class Solution {
    public boolean isValid(String str) {
        if (str.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        //for (int i = 0; i < str.length(); i ++) {
        for (char c : str.toCharArray()) {
            switch (c) {
              case '(':
                stack.push(')');
                break;
              case '{':
                stack.push('}');
                break;
              case '[':
                stack.push(']');
                break;
              case ')':
              case ']':
              case '}':      
                if (stack.isEmpty() || stack.pop() != c) return false;
                break;
            }
        }    
        return stack.isEmpty();
    }
}

/* using HashMap*/
public class Solution {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
       for (char c : s.toCharArray()) {
           if(map.containsKey(c)) {
               stack.push(c);
           } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
               return false;
           }
       }
       return stack.isEmpty();
    }
}

