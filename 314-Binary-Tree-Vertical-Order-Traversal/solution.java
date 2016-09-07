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
    
    private static class Node {
        TreeNode node;
        int pos;
        
        Node(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        int maxLeft = 0, maxRight = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(root, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.pos < maxLeft) {
                maxLeft = node.pos;
                res.add(0, new ArrayList<Integer>());
            } else if (node.pos > maxRight) {
                maxRight = node.pos;
                res.add(new ArrayList<Integer>());
            }
            int index = node.pos - maxLeft;
            res.get(index).add(node.node.val);
            if (node.node.left != null) {
                q.offer(new Node(node.node.left, node.pos - 1));
            }
            if (node.node.right != null) {
                q.offer(new Node(node.node.right, node.pos + 1));
            }
        }
        return res;
    }
}