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
    
    private int max;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.max = 0;
        dfs(root);
        return this.max;
    }
    
    private int dfs(TreeNode node) {
        int max = 1;
        if (node.left != null) {
            int tmp = dfs(node.left);
            if (node.val == node.left.val - 1) {
                max += tmp;
            }
        }
        if (node.right != null) {
            int tmp = dfs(node.right);
            if (node.val == node.right.val - 1) {
                max = Math.max(max, tmp + 1);
            }
        }
        this.max = Math.max(this.max, max);
        return max;
    }
}