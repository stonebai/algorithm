/**
 * For skyline problem
 **/
public class Solution {
    /**
     * store every edge in histogram.
     **/
    class Node {
        
        public int x;
        public int h;
        public boolean isLeft;
        
        public Node(int x, int h, boolean isLeft) {
            this.x = x;
            this.h = h;
            this.isLeft = isLeft;
        }
        
    }
    /**
     * This method solve the skyline problem.
     **/
    public List<int[]> getSkyline(int[][] buildings) {
        List<Node> list = new ArrayList<Node>(2 * buildings.length);    // for all nodes in histogram
        for(int i=0;i<buildings.length;i++) {
            list.add(new Node(buildings[i][0], buildings[i][2], true));
            list.add(new Node(buildings[i][1], buildings[i][2], false));
        }
        Collections.sort(list, new Comparator<Node>() {     // sort node according to this policy
            @Override
            public int compare(Node a, Node b) {
                if(a.x!=b.x) {
                    return a.x - b.x;
                }
                if(a.isLeft && b.isLeft) {
                    return b.h - a.h;
                }
                if(!a.isLeft && !b.isLeft) {
                    return a.h - b.h;
                }
                if(a.isLeft) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
        List<int[]> res = new ArrayList<int[]>();   // result list
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();    // use tree map to ensure log(n) time complexity
        for(int i=0;i<list.size();i++) {
            Node node = list.get(i);
            if(node.isLeft) {       // deal with left nodes
                if(map.isEmpty()) {
                    res.add(helper(node.x, node.h));
                }
                else if(node.h>map.lastKey()) {
                    res.add(helper(node.x, node.h));
                }
                if(map.containsKey(node.h)) {
                    int count = map.get(node.h);
                    map.put(node.h, count+1);
                }
                else {
                    map.put(node.h, 1);
                }
            }
            else {                  // deal with right nodes
                int count = map.get(node.h);
                count--;
                if(count==0) {
                    map.remove(node.h);
                }
                else {
                    map.put(node.h, count);
                }
                if(map.isEmpty()) {
                    res.add(helper(node.x, 0));
                }
                else if(node.h>map.lastKey()) {
                    res.add(helper(node.x, map.lastKey()));
                }
            }
        }
        return res;
    }
    /**
     * helper method used to create a solution point for result
     **/
    private int[] helper(int a, int b) {
        int[] res = new int[2];
        res[0] = a;
        res[1] = b;
        return res;
    }
}