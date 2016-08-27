/*
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode reversed = reverseList(head.next);
        ListNode last = reversed;
        while(last.next != null) {
            last = last.next;
        }
        last.next = head;
        head.next = null;
        return reversed;
    }
}
