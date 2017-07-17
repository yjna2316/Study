/**
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/#/description
 * 
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

/* (Two Stacks) Push - O(n) per operation, Pop - O(1) per operation 
 * Push - Space Complexity  O(n)
 */
public class MyQueue {
    Stack<Integer> s1, s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/* (Two Stacks) Push - O(1) per operation, Pop - Amortized O(1) per operation */

public class MyQueue {
    Stack<Integer> input, output;
    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    private int front;
    /** Push element x to the back of queue. */
    /* Time Complexity: O(1), Space Complexity: O(n) need additional memory to store the queue elements */
    public void push(int x) {
        if (input.empty()) {
            front = x;
        }
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
         if (output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return (output.isEmpty()) ? front : output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
