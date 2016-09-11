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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        for (String str : left) {
            res.add(root.val + "->" + str);
        }
        List<String> right = binaryTreePaths(root.right);
        for (String str : right) {
            res.add(root.val + "->" + str);
        }
        if (res.size() > 0) {
            return res;
        } else {
            res.add(String.valueOf(root.val));
            return res;
        }
    }
}