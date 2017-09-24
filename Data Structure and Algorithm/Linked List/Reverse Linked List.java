/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 */ 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* Solution 1 - Iteratively */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(0);
        ListNode p = head;
        prev.next = head;
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            q.next = prev.next;
            p.next = r;
            prev.next = q;
        }
        return prev.next;        
    }
}