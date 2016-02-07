/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return sortedListToBSTHelper(head, 0, len - 1);
    }

    public TreeNode sortedListToBSTHelper(ListNode head, int start, int end) {
        if(start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBSTHelper(head, start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        if(head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        root.right = sortedListToBSTHelper(head, mid + 1, end);
        return root;
    }
}
