public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> degree = new HashMap<Integer, Integer>();
        preprocess(edges, graph, degree);
        if (degree.size() != n) {
            return false;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                q.offer(key);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int key = q.poll();
            count++;
            for (int num : graph.get(key)) {
                int count = degree.get(num) - 1;
                degree.put(num, count);
                if (count == 1) {
                    q.offer(num);
                }
            }
        }
        return count == n;
    }
    
    private void preprocess(int[][] edges, Map<Integer, Set<Integer>> graph, Map<Integer, Integer> degree) {
        for (int[] edge : edges) {
            helper(graph, degree, edge[0], edge[1]);
            helper(graph, degree, edge[1], edge[0]);
        }
    }
    
    private void helper(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> degree, int i, int j) {
        if (graph.containsKey(i)) {
            if (graph.get(i).add(j)) {
                degree.put(i, degree.get(i) + 1);
            }
        } else {
            Set<Integer> set = new HashSet<Integer>();
            set.add(j);
            degree.put(i, 1);
            graph.put(i, set);
        }
    }
}