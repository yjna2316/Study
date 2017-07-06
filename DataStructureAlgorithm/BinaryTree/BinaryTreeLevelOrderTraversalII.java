/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // using two lists and queue without stack
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        if (root == null) return wrapList;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> subList = new ArrayList<>();
            while (level-- > 0) {
                root = q.poll();
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
                subList.add(root.val);
            }
            wrapList.add(0,subList);
        }
        return wrapList;
    }
}

// using two lists and queue with stack
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        if (root == null) return wrapList;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();
        
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            while (level-- > 0) {
                root = q.poll();
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
                list.add(root.val);
            }
            s.push(list);
        }
        while(!s.isEmpty()) {
            wrapList.add(s.pop());
        }
        return wrapList;
    }
}

