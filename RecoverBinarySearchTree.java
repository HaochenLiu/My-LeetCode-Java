/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inorderTraversal(root, list);
        TreeNode first = null;
        TreeNode second = null;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                if (first == null)
                    first = list.get(i - 1);
                second = list.get(i);
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void inorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);
    }
}
