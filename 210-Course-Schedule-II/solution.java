public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0;i < numCourses;i++) set.add(i);
        Map<Integer, List<Integer>> dg = drawGraph(prerequisites);
        List<Integer> list = topoSort(dg, set);
        int[] res = new int[list.size()];
        for (int i = 0;i < res.length;i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private List<Integer> topoSort(Map<Integer, List<Integer>> dg, Set<Integer> set) {
        List<Integer> res = new ArrayList<Integer>();
        while (!dg.isEmpty()) {
            Integer tmp = dg.keySet().iterator().next();
            if (!dfs(dg, set, tmp, res)) {
                return new ArrayList<Integer>();
            }
        }
        for (Integer n : set) {
            res.add(n);
        }
        return res;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> dg, Set<Integer> set, Integer n, List<Integer> res) {
        if (!set.remove(n)) return false;
        if (dg.containsKey(n)) {
            for (Integer tmp : dg.get(n)) {
                if(!dfs(dg, set, tmp, res)) {
                    return false;
                }
            }
        }
        dg.remove(n);
        res.add(n);
        return true;
    }
    
    private Map<Integer, List<Integer>> drawGraph(int[][] pres) {
        Map<Integer, List<Integer>> dg = new HashMap<Integer, List<Integer>>();
        for (int[] pre : pres) {
            if (!dg.containsKey(pre[0])) {
                dg.put(pre[0], Collections.singletonList(pre[1]));
            } else {
                dg.get(pre[0]).add(pre[1]);
            }
        }
        return dg;
    }
}