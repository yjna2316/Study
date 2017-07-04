/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description
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
 
// Divide and Conquer, O(n) runtime, O(logn) stack space
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       return insertNode(nums, 0, nums.length - 1);
    }
    private TreeNode insertNode(int[] nums, int left, int right) {
        TreeNode node = null;
        if (left <= right) {
            int mid = (left + right) / 2;
            node = new TreeNode(nums[mid]);
            node.left = insertNode(nums, left, mid - 1);
            node.right = insertNode(nums, mid + 1, right);
        }
        return node;
    }
}