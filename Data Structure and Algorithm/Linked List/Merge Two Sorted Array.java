/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* Solution 1 - Iterative way using dummy list node */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = (l1 == null) ? l2 : l1;
        return head.next;
    }
}

/* Solution 2 - recursively */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            if(l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else{
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
}