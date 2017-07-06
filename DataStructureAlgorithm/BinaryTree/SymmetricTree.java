/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/#/description
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* Recursive solution */
public boolean isSymmetric(TreeNode root) {
  return (root == null) || isSymmetricHelp(root.left, root.right);
}
private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
  if (left == null || right == null) return left == right;
  return (left.val == right.val) && isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}
 
 /* Interative solution with one queue */
public boolean isSymmetric(TreeNode root) {
  Queue<TreeNode> q = new LinkedList<>();
  q.add(root);
  q.add(root);
  while (!q.isEmpty()) {
    TreeNode left = q.poll();
    TreeNode right = q.poll();
    if (left == null || right == null) return left == right;
    if (left.val != right.val) return false
    q.add(left.left);
    q.add(right.right);
    q.add(left.right);
    q.add(right.left);
  }
  return true;
}
 /* Iterative solution with two queues */
public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();
        
        leftQ.add(root);
        rightQ.add(root);
        while (!leftQ.isEmpty()) {
            int level = leftQ.size();
            while (level -- > 0) {
                TreeNode left = leftQ.poll();
                TreeNode right = rightQ.poll();
                if (left != null && right == null || left == null && left != null) return false;
                if (left != null && right != null && left.val != right.val) return false;
                if (left != null) {
                    leftQ.add(left.left);
                    leftQ.add(left.right);
                }
                if (right != null) {
                    rightQ.add(right.right);
                    rightQ.add(right.left);
                }
                
            }
        }
        return true;
    }