/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/#/description
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/* Using one queue, push is O(n) and the others O(1) */
public class MyStack {
    Queue<Integer> q;
    public MyStack() {
      q = new LinkedList<>();
    }
    public void push(int x) {
        q.add(x);
        int num = q.size();
        while (num > 1) {
            q.add(q.remove());
            num --;
        }
    }
    public int pop() {
        return q.remove();
    }
    public int top() {
        return q.peek();
    }
    public boolean empty() {
        return q.isEmpty();
    }
}