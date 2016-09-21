public class Solution {
    
    static class Node {
        int val;
        int dup;
        int count;
        Node left;
        Node right;
        
        Node (int val) {
            this.val = val;
            this.dup = 1;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        int[] array = new int[len];
        array[len - 1] = 0;
        Node root = new Node(nums[len - 1]);
        for (int i = len - 2;i >= 0;i--) {
            array[i] = insert(root, nums[i]);
        }
        for (int i = 0;i < len;i++) {
            res.add(array[i]);
        }
        return res;
    }
    
    private int insert(Node node, int val) {
        int count = 0;
        while (true) {
            if (val < node.val) {
                node.count++;
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new Node(val);
                    return count;
                }
            } else if (val > node.val) {
                count += node.count + node.dup;
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new Node(val);
                    return count;
                }
            } else {
                node.dup++;
                return count + node.count;
            }
        }
    }
}