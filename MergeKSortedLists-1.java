/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, 
                new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = (ListNode) pq.poll();
            if (node.next != null)
                pq.add(node.next);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
