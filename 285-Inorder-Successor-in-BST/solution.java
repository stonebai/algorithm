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
        if (root == null || p == null) {
            return null;
        } else {
            return dfs(root, p);
        }
    }
    
    private TreeNode dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            return mostLeft(root.right);
        } else if (root.val < p.val) {
            return dfs(root.right, p);
        } else {
            TreeNode tmp = dfs(root.left, p);
            if (tmp != null) {
                return tmp;
            } else {
                return root;
            }
        }
    }
    
    private TreeNode mostLeft(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left != null) {
            return mostLeft(root.left);
        } else {
            return root;
        }
    }
}