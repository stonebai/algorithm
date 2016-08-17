public class Solution {
    
    class Node {
        public int i1;
        public int i2;
        public long sum;
        
        public Node (int i1, int i2, int n1, int n2) {
            this.i1 = i1;
            this.i2 = i2;
            this.sum = (long)n1 + n2;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return Long.compare(a.sum, b.sum);
            }
        });
        for (int i = 0;i < nums1.length;i++) {
            q.offer(new Node(i, 0, nums1[i], nums2[0]));
        }
        for (int i = 0;i < k;i++) {
            Node node = q.poll();
            int[] tmp = new int[2];
            tmp[0] = nums1[node.i1];
            tmp[1] = nums2[node.i2];
            res.add(tmp);
            if (node.i2 + 1 < nums2.length) {
                q.offer(new Node(node.i1, node.i2 + 1, nums1[node.i1], nums2[node.i2 + 1]));
            }
        }
        return res;
    }
}