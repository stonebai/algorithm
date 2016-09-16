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
    public int closestValue(TreeNode root, double target) {
        if (target > root.val && root.right != null) {
            int tmp = closestValue(root.right, target);
            double a = Math.abs(target - root.val);
            double b = Math.abs(target - tmp);
            if (a <= b) {
                return root.val;
            } else {
                return tmp;
            }
        } else if (target < root.val && root.left != null) {
            int tmp = closestValue(root.left, target);
            double a = Math.abs(target - root.val);
            double b = Math.abs(target - tmp);
            if (a <= b) {
                return root.val;
            } else {
                return tmp;
            }
        } else {
            return root.val;
        }
    }
}