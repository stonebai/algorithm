public class Solution {
    public String alienOrder(String[] words) {
        Set<Character> all = getSet(words);
        Map<Character, Set<Character>> map = preprocess(words);
        StringBuilder sb = new StringBuilder();
        for (char key : all) {
            if (dfs(key, map, sb, new boolean[26], all)) {
                return "";
            }
        }
        return sb.toString();
    }
    
    private boolean dfs(char key, Map<Character, Set<Character>> map, StringBuilder sb, boolean[] visited, Set<Character> all) {
        int index = key - 'a';
        if (visited[index]) {
            return true;
        }
        if (!all.contains(key)) {
            return false;
        }
        visited[index] = true;
        if (map.containsKey(key)) {
            for (char ch : map.get(key)) {
                if (dfs(ch, map, sb, visited, all)) {
                    return true;
                }
            }
        }
        visited[index] = false;
        all.remove(key);
        sb.insert(0, key);
        return false;
    }
    
    private Map<Character, Set<Character>> preprocess(String[] words) {
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
                return;
            }
        }
    }
    
    private Set<Character> getSet(String[] words) {
        Set<Character> set = new HashSet<Character>();
        for (String word : words) {
            char[] chs = word.toCharArray();
            for (char ch : chs) {
                set.add(ch);
            }
        }
        return set;
    }
}