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
    
    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }
    
    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if(root==null) return res;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}