/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode l = new ListNode(0);
        ListNode dummy = l;
        int tmp = 0;
        while(l1 != null || l2 != null || tmp != 0) {
            if(l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            l.next = new ListNode(tmp % 10);
            l = l.next;
            tmp /= 10;
        }
        return dummy.next;
    }
}
