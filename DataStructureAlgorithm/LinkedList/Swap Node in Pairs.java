/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/discuss/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode first = dummy.next;
        while (first != null && first.next != null) {
            ListNode second = first.next, third = first.next.next;
            prev.next = second;
            second.next = first;
            first.next = third;
            prev = first;
            first = third;
        }
        return dummy.next;
    }
}