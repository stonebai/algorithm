public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        fillMap(prerequisites, map);
        return !findLoops(map);
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
    
    private boolean findLoops(Map<Integer, List<Integer>> map) {
        for (Integer i : map.keySet()) {
            Set<Integer> visited = new HashSet<Integer>();
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(i);
            visited.add(i);
            while (!stack.isEmpty()) {
                Integer tmp = stack.pop();
                if (visited.contains(tmp)) {
                    return true;
                } else {
                    visited.add(tmp);
                }
                if (map.containsKey(tmp)) {
                    for (Integer j : map.get(tmp)) {
                        stack.push(j);
                    }
                }
            }
        }
        return false;
    }
}