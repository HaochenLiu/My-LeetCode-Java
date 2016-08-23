/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    private int getCnt(ListNode node) {
        int res = 0;
        while(node != null) {
            node = node.next;
            res++;
        }

        return res;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        int reverseTime = getCnt(head) / k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        
        for(int i = 0; i < reverseTime; i++) {
            for(int j = 0; j < k - 1; j++) {
                ListNode move = cur.next;
                cur.next = move.next;
                move.next = pre.next;
                pre.next = move;
            }
            pre = cur;
            cur = pre.next;
        }
        return dummy.next;
    }
}
