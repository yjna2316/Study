
/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/#/description
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* recursive solution - optimized the one below*/
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
       if (root == null) return false;
       if (sum - root.val == 0 && root.left == null && root.right == null) return true;
       return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
} 

/* before optimized - unnecessary variables used */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean hasPath = false;
        if (root != null) {
            int mid = sum -root.val;
            if (mid == 0 && root.left == null && root.right == null) return true;
            if (root.left != null) 
                hasPath = hasPathSum(root.left, mid); 
            if (!hasPath && root.right != null) 
                hasPath = hasPathSum(root.right, mid);
        }
        return hasPath;
    }
}