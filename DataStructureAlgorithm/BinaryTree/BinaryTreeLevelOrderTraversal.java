/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
 
/** 
 * Next Challenges: (E) Binary Tree Level Order Traversal2, (M) Binary Tree Zigzag Level Order Traversal,
 * (M) Binary Tree Vertical Order Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Breadth-first traversal using queue
 public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return result;
        q.add(root);
        
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            while (level -- > 0) {
                TreeNode node = q.remove();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}