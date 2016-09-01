public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        fillMap(prerequisites, map);
        Set<Integer> dp = new HashSet<Integer>();
        for (Integer i : map.keySet()) {
            if (!dfs(i, map, new HashSet<Integer>(), dp)) {
                return false;
            }
        }
        return true;
    }
    
    private void fillMap(int[][] pres, Map<Integer, Set<Integer>> map) {
        for (int[] p : pres) {
            if (map.containsKey(p[0])) {
                map.get(p[0]).add(p[1]);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(p[1]);
                map.put(p[0], set);
            }
        }
    }
    
    private boolean dfs(Integer num, Map<Integer, Set<Integer>> map, Set<Integer> visited, Set<Integer> dp) {
        if (visited.contains(num)) {
            return false;
        } else {
            visited.add(num);
        }
        if (dp.contains(num)) {
            visited.remove(num);
            return true;
        }
        if (map.containsKey(num)) {
            for (Integer i : map.get(num)) {
                if (!dfs(i, map, visited, dp)) {
                    return false;
                }
            }
        }
        visited.remove(num);
        dp.add(num);
        return true;
    }
}