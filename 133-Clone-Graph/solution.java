/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q1 = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q2 = new LinkedList<UndirectedGraphNode>();
        q1.offer(node);
        q2.offer(root);
        Map<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
        visited.put(root.label, root);
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0;i < size;i++) {
                UndirectedGraphNode n1 = q1.poll();
                UndirectedGraphNode n2 = q2.poll();
                for (UndirectedGraphNode t1 : n1.neighbors) {
                    if (visited.contains(t1.label)) {
                        n2.neighbors.add(visited.get(t1.label));
                        continue;
                    }
                    UndirectedGraphNode t2 = new UndirectedGraphNode(t1.label);
                    visited.put(t1.label, t2);
                    n2.neighbors.add(t2);
                    q1.offer(t1);
                    q2.offer(t2);
                }
            }
        }
        return root;
    }
}