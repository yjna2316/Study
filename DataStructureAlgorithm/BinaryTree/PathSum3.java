/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/#/description
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Time Complexity
 * O(n^2) in worst case (no branching)
 * O(nlogn) in best case (balanced tree)
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        return ((sum == root.val) ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
    }
}