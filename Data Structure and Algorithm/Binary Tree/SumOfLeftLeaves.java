/** 
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/#/description
 *
 * * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /* top-down recursive */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
} 

/**
 * using Stack
 * referenced : https://discuss.leetcode.com/topic/60415/java-solution-with-stack/3
 */
public class Solution {
 public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.left != null && node.left.left == null && node.left.right == null)
                    res += node.left.val;
                stack.push(node.left);
                stack.push(node.right);
            }
        }

        return res;
    }
}

/** 
 * using Queue
 * referenced : https://discuss.leetcode.com/topic/60415/java-solution-with-stack/3
 */
public class Solution {
 public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.offer(root);
        while(queue.size() != 0) {
            TreeNode head = queue.poll();
            if (head!= null) {
                if ( head.left != null && head.left.left == null && head.left.right == null) {
                    res += head.left.val;
                }
                queue.offer(head.left);
                queue.offer(head.right);
            }
        }
        return res;
    }
}