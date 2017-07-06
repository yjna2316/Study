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