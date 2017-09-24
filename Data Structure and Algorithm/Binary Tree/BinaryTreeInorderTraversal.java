/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/#/description

/**
 * Next Challenges: (M) Validate Binary Search Tree, (M) Binary Tree Preorder Traversal,
 * (M) Binary Search Tree Iterator, (M) Kth Smallest Element in a BST, (M) Inorder Successor in BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /*
 * Iterative Inorder Traversal Using Stack 
 * Runtime = O(n): As each node is visited once
 * Space = O(n)
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null || !s.isEmpty()) {
            while (root != null) { // Backtrack to higher level node A
                s.push(root);
                root = root.left;
            }
            root = s.pop(); // Backtrack to higher level node A
            list.add(root.val); // Add the node to the result list
            root = root.right; // Switch to A's right branch
        }
        return list;
    }
}

