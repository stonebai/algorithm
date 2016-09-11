/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeLinkNode pre = q.poll();
            int size = q.size();
            if (pre.left != null) {
                q.offer(pre.left);
            }
            if (pre.right != null) {
                q.offer(pre.right);
            }
            for (int i = 0;i < size;i++) {
                TreeLinkNode cur = q.poll();
                pre.next = cur;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                pre = cur;
            }
        }
    }
}