/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
Credits:
Special thanks to @ts for adding this problem and creating all test cases.
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int count = k;
        while (cur != null || stack.size() > 0) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                count--;
                if (count == 0)
                    return cur.val;
                cur = cur.right;
            }
        }
        return 0;
    }
}
