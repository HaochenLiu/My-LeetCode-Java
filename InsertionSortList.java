/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode p = head.next, pStart = new ListNode(0), pEnd = head;
        pStart.next = head;
        while(p != null) {
            ListNode temp = pStart.next, prev = pStart;
            while(temp != p && p.val >= temp.val) {
                temp = temp.next;
                prev = prev.next;
            }
            if(temp == p)
                pEnd = p;
            else {
                pEnd.next = p.next;
                p.next = temp;
                prev.next = p;
            }
            p = pEnd.next;
        }
        head = pStart.next;
        return head;
    }
}
