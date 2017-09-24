/**
 * https://leetcode.com/problems/remove-linked-list-elements/#/description
 * 203. Remove Linked List Elements
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /* Solution 1 - Iterative solution without dummy */ 
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return (head.val == val) ? head.next : head;
    }
}

/* Solution 2 - Recursive solution without dummy */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return (head.val == val) ? head.next : head;
       
    }
}

/**
 * Solution 3 - using dummy head 
 * so that the new list's head could easily be returned
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null) {
            if (head.val != val) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}