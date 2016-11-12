/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            sb.append(cur.val + " ");
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
        System.out.println(sb.substring(0, sb.length()-1));
        return sb.substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] nodes = data.split(" ");
        return helper(nodes, 0, nodes.length-1);
    }
    
    public TreeNode helper(String[] nodes, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[start]));
        if(start == end) return root;
        int left = start + 1, right = end + 1;
        while(left < right) {
            int mid = (right - left)/2 + left;
            if(Integer.valueOf(nodes[mid]) < root.val) left = mid + 1;
            else right = mid;
        }
        root.left = helper(nodes, start+1, right-1);
        root.right = helper(nodes, right, end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
