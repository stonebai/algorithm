public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        fillMap(prerequisites, map);
        boolean[] dp = new boolean[numCourses];
        for (Integer i : map.keySet()) {
            if (!dfs(i, map, new boolean[numCourses], dp)) {
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
    
    private boolean dfs(Integer num, Map<Integer, Set<Integer>> map, boolean[] visited, boolean[] dp) {
        if (visited[num.intValue()]) {
            return false;
        } else {
            visited[num.intValue()] = true;
        }
        if (dp[num.intValue()]) {
            visited[num.intValue()] = false;
            return true;
        }
        if (map.containsKey(num)) {
            for (Integer i : map.get(num)) {
                if (!dfs(i, map, visited, dp)) {
                    return false;
                }
            }
        }
        visited[num.intValue()] = false;
        dp[num.intValue()] = true;
        return true;
    }
}