// public class Solution {
//     public int[] findOrder(int num, int[][] pre) {
//         Map<Integer, Set<Integer>> map = getMap(pre);
//         List<Integer> list = new ArrayList<Integer>();
//         boolean[] courses = new boolean[num];
//         for (int i = 0;i < num;i++) {
//             if (courses[i]) {
//                 continue;
//             } else {
//                 if (!dfs(i, map, list, new boolean[num], courses)) {
//                     return new int[0];
//                 }
//             }
//         }
//         int[] res = new int[num];
//         for (int i = 0;i < num;i++) {
//             res[i] = list.get(i).intValue();
//         }
//         return res;
//     }
    
//     private boolean dfs(int num, Map<Integer, Set<Integer>> map, List<Integer> list, boolean[] visited, boolean[] courses) {
//         if (visited[num]) {
//             return false;
//         }
//         if (courses[num]) {
//             return true;
//         }
//         if (map.containsKey(num)) {
//             visited[num] = true;
//             for (Integer i : map.get(num)) {
//                 if (!dfs(i.intValue(), map, list, visited, courses)) {
//                     return false;
//                 }
//             }
//             visited[num] = false;
//         }
//         list.add(num);
//         courses[num] = true;
//         return true;
//     }
    
//     private Map<Integer, Set<Integer>> getMap(int[][] pre) {
//         Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
//         for (int[] p : pre) {
//             if (map.containsKey(p[0])) {
//                 map.get(p[0]).add(p[1]);
//             } else {
//                 Set<Integer> set = new HashSet<Integer>();
//                 set.add(p[1]);
//                 map.put(p[0], set);
//             }
//         }
//         return map;
//     }
// }
public class Solution {
    public int[] findOrder(int num, int[][] pre) {
        int[] res = new int[num];
        HashSet<Integer>[] g = new HashSet<Integer>[num];
        int[] d = new int[num];
        initialization(pre, g, d);
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0;i < num;i++) {
            if (d[i] == 0) {
                q.offer(i);
            }
        }
        int count = q.size();
        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            res[index++] = course;
            if (g[course] != null) {
                for (int c : g[course]) {
                    if (--d[c] == 0) {
                        q.offer(c);
                        count++;
                    }
                }
            }
        }
        if (count == num) return res;
        else return new int[0];
    }
    
    private void initialization(int[][] pre, Set<Integer>[] g, int[] d) {
        for (int[] p : pre) {
            if (g[p[1]] == null) {
                g[p[1]] = new HashSet<Integer>();
            }
            g[p[1]].add(p[0]);
            d[p[0]]++;
        }
    }
}