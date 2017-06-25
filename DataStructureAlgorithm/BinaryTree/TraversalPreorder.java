/* Binary Tree PreOrder Traveral In Java */
import java.util.Stack;
public class BinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
      this.data = data;
    }
  }
  // Recursive Solution 
  public void preorder(TreeNode root) {
    if (root != null) {
      System.out.print(root.val + " ");
      preorder(root.left);
      preorder(root.right);
    }
  }
  // Iterative Solution with stack
  public void preorderIter1(TreeNode root) {
    if(root == null) return;
    Stack stack = new Stack();
    stack.push(root);
    while(!stack.isEmpty()) {
      TreeNode n = stack.pop();
      System.out.println(n.val);
      if (n.right != null) {
        s.push(n.right);
      }
      if (n.left != null) {
        s.push(n.left);
      }
    }
  }
}
