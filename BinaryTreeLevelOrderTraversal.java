/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        if (root != null)
            cur.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            list.add(node.val);
            if (node.left != null)
                next.offer(node.left);
            if (node.right != null)
                next.offer(node.right);
            if (cur.isEmpty()) {
                result.add(list);
                list = new ArrayList<Integer>();
                cur = next;
                next = new LinkedList<TreeNode>();
            }
        }
        return result;
    }
}
