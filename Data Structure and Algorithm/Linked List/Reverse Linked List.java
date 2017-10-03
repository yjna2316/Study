/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 * (M)Reverse Linked List II (M)Binary Tree Upside Down (E)Palindrome Linked List 
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
public class Solution1 {
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

/**
 * Solution 2 
 * Use 3 pointers to reverse the list, iteratively
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}