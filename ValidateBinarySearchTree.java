/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            if (root.val <= root.left.val || root.val <= cur.val)
                return false;
        }
        if (root.right != null) {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            if (root.val >= root.right.val || root.val >= cur.val)
                return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
