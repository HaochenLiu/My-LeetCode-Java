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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null || root.val==key) return deleteRoot(root);
        TreeNode p=root;
        
        while (true) { // search the node
            if (key>p.val) {
                if (p.right==null || p.right.val==key) {
                    p.right=deleteRoot(p.right);
                    break;
                }
                p=p.right;
            }
            else {
                if (p.left==null || p.left.val==key) {
                    p.left=deleteRoot(p.left);
                    break;
                }
                p=p.left;
            }
        }
        return root;
    }

    private TreeNode deleteRoot(TreeNode root) {
        if (root==null) return null;
        if (root.right==null) return root.left;
        TreeNode x=root.right; // root.right should be the new root
        while (x.left!=null) x=x.left; // find the left-most node
        x.left=root.left;
        return root.right;
    }
}
