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
    
    private static final String S = ",";
    
    private static final String N = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append(N + S);
            } else {
                sb.append(node.val + S);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(S);
        if (split[0].equals(N)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!split[i].equals(N)) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                q.offer(node.left);
            }
            i++;
            if (!split[i].equals(N)) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));