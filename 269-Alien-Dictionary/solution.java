public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = getMap(words);
        StringBuilder sb = new StringBuilder();
        boolean[] dp = new boolean[26];
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            if (dfs(entry.getKey(), map, sb, new boolean[26], dp)) {
                return "";
            }
        }
        return sb.toString();
    }
    
    private boolean dfs(char key, Map<Character, Set<Character>> map, StringBuilder sb, boolean[] visited, boolean[] dp) {
        int index = key - 'a';
        if (visited[index]) {
            return true;
        }
        if (dp[index]) {
            return false;
        }
        visited[index] = true;
        if (map.containsKey(key)) {
            for (char ch : map.get(key)) {
                if (dfs(ch, map, sb, visited, dp)) {
                    return true;
                }
            }
        }
        visited[index] = false;
        dp[index] = true;
        sb.insert(0, key);
        return false;
    }
    
    private Map<Character, Set<Character>> getMap(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        for (int i = 1;i < words.length;i++) {
            add(words[i - 1].toCharArray(), words[i].toCharArray(), map);
        }
        return map;
    }
    
    private void add(char[] chs1, char[]chs2, Map<Character, Set<Character>> map) {
        int i = 0, j = 0;
        while (i < chs1.length && j < chs2.length) {
            if (chs1[i] == chs2[j]) {
                i++;
                j++;
            } else {
                if (map.containsKey(chs1[i])) {
                    map.get(chs1[i]).add(chs2[j]);
                } else {
                    Set<Character> set = new HashSet<Character>();
                    set.add(chs2[j]);
                    map.put(chs1[i], set);
                }
            }
        }
    }
}