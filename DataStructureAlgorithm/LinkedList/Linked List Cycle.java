/*
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 */ 

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
   public boolean hasCycle(ListNode head){
       if(head == null || head.next == null) return false;
       if(head.next == head) return true;
       ListNode nextNode = head.next; 
       head.next = head;
       boolean isCycle = hasCycle(nextNode);
       return isCycle;
   }
}

public class Solution {
   public boolean hasCycle(ListNode head){
       // set two runners
       ListNode slow = head;
       ListNode fast = head;

        // fast runner move 2 steps at one time while slow runner move 1 step,
        // if traverse to a null, there must be no loop
    while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast) return true;
    }
    return false;
   }
}
