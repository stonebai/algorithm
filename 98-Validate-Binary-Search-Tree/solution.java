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
    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     TreeNode pre = null;
    //     TreeNode cur = root;
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     while (cur != null || !stack.isEmpty()) {
    //         while (cur != null) {
    //             stack.push(cur);
    //             cur = cur.left;
    //         }
    //         cur = stack.pop();
    //         if (pre != null && cur.val <= pre.val) {
    //             return false;
    //         }
    //         pre = cur;
    //         cur = cur.right;
    //     }
    //     return true;
    // }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int[] tmp = dfs(root);
        return tmp[2] != -1;
    }
    
    private int[] dfs(TreeNode root) {
        int[] res = new int[3];
        res[0] = root.val;
        res[1] = root.val;
        if (root.left != null) {
            int[] tmp = dfs(root.left);
            if (tmp[2] == -1 || tmp[0] >= root.val) {
                res[2] = -1;
                return res;
            }
            res[1] = tmp[1];
        }
        if (root.right != null) {
            int[] tmp = dfs(root.right);
            if (tmp[2] == -1 || tmp[1] <= root.val) {
                res[2] = -1;
                return res;
            }
            res[0] = tmp[0];
        }
        return res;
    }
}