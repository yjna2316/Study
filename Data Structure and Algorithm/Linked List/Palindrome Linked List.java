/** 
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * (E)Palindrome Number (E)Valid Palindrome (E)Reverse Linked List (M)Partition List (M)Longest Word in Dictionary through Deleting
 * (M)Reorder List (M)Minimum Size Subarray Sum (M)Permutation in String
 * (M)Rotate List (M)Copy List with Random Pointer (M)Reorder List
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null) return true;
        
        int count = 1;
        ListNode next = head; // The pointer which points out the node in the middle of the linked list 
        
        // Count the number of the nodes in the linked list
        while (next != null)
        {
            next = next.next;
            count ++;
        }
        
        next = head;
        count = count / 2; 
        
        // Place the pointer on the middle of the linked list
        while (count -- > 0) {
            next = next.next;
        }
        
        // Reverse the sublist pointed by the node pointer
        next = reverse(next);       
        
        while (next != null) {
            if (head.val != next.val) 
                return false;
            head = head.next;
            next = next.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null; 
        while (head != null) 
        {   ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
        
    }
}