/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/#/description
 *
 **
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Brute force top-down recursion: O(n^2) runtime, O(n) stack space
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// Bottom-up recursion: O(n) runtime, O(n) stack space
public class Solution {
  public boolean isBalanced(TreeNode root) {
    return maxDepth(root) != -1;
  }
  private int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int L = maxDepth(root.left);
    if (L == -1) return -1;
    int R = maxDepth(root.right);
    if (R == -1) return -1;
    return (Math.abs(L - R) <= 1) ? (Math.max(L, R) + 1) : -1;
  }
}




