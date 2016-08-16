public class Solution {
    
    private class Node {
        
        public int num;
        public int count;
        
        public Node(int num) {
            this.num = num;
            this.count = 1;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        List<Node> nodes = new ArrayList<Node>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.get(num).count++;
            } else {
                Node node = new Node(num);
                map.put(num, node);
                nodes.add(node);
            }
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return b.count - a.count;
            }
        });
        Iterator<Node> iter = nodes.iterator();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0;i < k && iter.hasNext();i++) {
            res.add(iter.next().num);
        }
        return res;
    }
}