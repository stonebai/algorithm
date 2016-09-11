/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = this.stack.pop();
        TreeNode cur = node.right;
        while (cur != null) {
            this.stack.push(cur);
            cur = cur.left;
        }
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */