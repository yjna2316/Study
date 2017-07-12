/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/#/description
 * 
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/* using one stack */
public class MinStack {
    Stack<Integer> S;
    int min;
    public MinStack() {
        S = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {  
        if (x <= min) {
            S.push(min);
            min = x;
        }
        S.push(x);
    }
    
    public void pop() {
        if (S.pop() == min) min = S.pop();
    }
    
    public int top() {
        return S.peek();
    }
    
    public int getMin() {   
        return min;
    }
}

/* using two stacks */
public class MinStack {
    Stack<Integer> stack, minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {  
        stack.push(x);  
        if (minStack.isEmpty() ||  x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    /* As the methods return an object, should use equals() to compare the contents in the object */
    public void pop() {
        if (stack.pop().equals(minStack.peek())) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {   
        return minStack.peek();
    }
}

