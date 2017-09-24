/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/solutions
 * 
 * Next Challenges : 
 * (E) Arranging Coins(E) Find Mode in Binary Search Tree(M) Binary Tree Longest Consecutive Sequence II
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // Inorder Traversa using stack 
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
    
}