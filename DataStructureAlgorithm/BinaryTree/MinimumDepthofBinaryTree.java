/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Depth-first traversal - traverses all nodes, stack
 * O(n) runtime, O(logn) space 
 */ 
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left, root.right)) + 1;
    }
}
/**
 * Breadth-first traversal - unbalanced tree, does'nt need to traverse all, queue   
 * O(n) runtime, O(n) space
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 1;
        TreeNode rightmost = root;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left == null && node.right == null) break;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            if (node == rightmost) {
                rightmost = (node.right == null) ? node.left : node.right;
                depth ++;
            }
        }
        return depth;
    }
}
