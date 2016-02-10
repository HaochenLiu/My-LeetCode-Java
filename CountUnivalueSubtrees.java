/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
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
    public int countUnivalSubtrees(TreeNode root) {
        return Math.abs(countUnivalSubtreesHelper(root));
    }

    private int countUnivalSubtreesHelper(TreeNode root) {
        if (root == null)
            return 0;
        int left = countUnivalSubtreesHelper(root.left);
        int right = countUnivalSubtreesHelper(root.right);
        int abs = Math.abs(left) + Math.abs(right);
        if ((left == 0 || (left > 0 && root.left.val == root.val))
            && (right == 0 || (right > 0 && root.right.val == root.val)))
            return abs + 1;
        else
            return -abs;
    }
}
