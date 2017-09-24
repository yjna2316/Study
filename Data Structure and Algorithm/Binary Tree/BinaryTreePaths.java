/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/#/description
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /* substring(start, end)???
 /* using StringBuffer with setLength to avoid holding its value after returning */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
 /* using String creates a copy in every recursion, memory efficiency low */ 
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        return (root == null) ? list : helper("", list, root);   
    }    
    private List<String> helper(String path, List<String> list, TreeNode root) {
        if (root.left == null && root.right == null) list.add(path + root.val);
        if (root.left != null) helper(path + root.val + "->", list, root.left);
        if (root.right != null) helper(path + root.val + "->", list, root.right);
        return list;
    }
}