/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode move = cur.next;
            cur.next = move.next;
            move.next = pre.next;
            pre.next = move;
        }
        return dummy.next;
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode cur = head;
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (cur2.next != null && cur2.next.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        cur2 = reverseList(cur1.next);  
        cur1.next = null;
        cur1 = head.next;
        while (cur1 != null || cur2 != null) {
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;
            cur.next = cur1;
            if (cur1 != null) {
                cur1 = cur1.next;
                cur = cur.next;
            }
        }
    } 
}
