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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offerFirst(root);
        TreeNode pre = null;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            if (node.val == p.val) {
                if (node.right != null) {
                    return mostLeft(node.right);
                } else {
                    return pre;
                }
            } else if (node.val > p.val) {
                if (node.left != null) {
                    deque.offerFirst(node.left);
                    pre = node;
                } else {
                    return null;
                }
            } else {
                if (node.right != null) {
                    deque.offerFirst(node.right);
                } else {
                    return null;
                }
            }
        }
        return null;
    }
    
    private TreeNode mostLeft(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}