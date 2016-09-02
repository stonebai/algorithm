public class Solution {
    
    class Node {
        int x;
        int h;
        boolean isLeft;
        
        Node(int x, int h, boolean isLeft) {
            this.x = x;
            this.h = h;
            this.isLeft = isLeft;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<Node> pq = preProcess(buildings);
        List<int[]> res = new ArrayList<int[]>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.isLeft) {
                if (map.isEmpty() || node.h > map.lastEntry().getKey()) {
                    int[] e = new int[2];
                    e[0] = node.x;
                    e[1] = node.h;
                    res.add(e);
                }
                if (map.containsKey(node.h)) {
                    map.put(node.h, map.get(node.h) + 1);
                } else {
                    map.put(node.h, 1);
                }
            } else {
                int num = map.get(node.h);
                if (num == 1) {
                    map.remove(node.h);
                } else {
                    map.put(node.h, num - 1);
                }
                if (!map.isEmpty()) {
                    int hi = map.lastEntry().getKey();
                    if (node.h > hi) {
                        int[] e = new int[2];
                        e[0] = node.x;
                        e[1] = hi;
                        res.add(e);
                    }
                } else {
                    int[] e = new int[2];
                    e[0] = node.x;
                    e[1] = 0;
                    res.add(e);
                }
            }
        }
        return res;
    }
    
    private PriorityQueue<Node> preProcess(int[][] buildings) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(50, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                } else {
                    if (a.isLeft && b.isLeft) {
                        return b.h - a.h;
                    } else {
                        if (!a.isLeft && !b.isLeft) {
                            return a.h - b.h;
                        } else {
                            if (a.isLeft) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    }
                }
            }
        });
        for (int[] building : buildings) {
            pq.offer(new Node(building[0], building[2], true));
            pq.offer(new Node(building[1], building[2], false));
        }
        return pq;
    }
}