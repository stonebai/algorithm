public class Solution {
    
    class Node {
        boolean isWord;
        Node[] next;
        
        Node() {
            this.isWord = false;
            this.next = new Node[26];
        }
    }
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Node root = buildTrie(Set<String> wordDict);
        return dfs(s, root, new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, Node root, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<String>();
        char[] chs = s.toCharArray();
        Node cur = root;
        for (int i = 0;i < chs.length;i++) {
            int offset = chs[i] - 'a';
            if (cur.next[offset] == null) {
                map.put(s, res);
                return res;
            } else {
                cur = cur.next[offset];
                if (cur.isWord) {
                    List<String> list = dfs(s.substring(i + 1), root, map);
                    String prefix = s.substring(0, i + 1);
                    for (String str : list) {
                        res.add(prefix + " " + str);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
    
    private Node buildTrie(Set<String> wordDict) {
        Node root = new Node();
        for (String word : wordDict) {
            Node cur = root;
            char[] chs = word.toCharArray();
            for (char ch : chs) {
                int offset = ch - 'a';
                if (cur.next[offset] == null) {
                    cur.next[offset] = new Node();
                }
                cur = cur.next[offset];
            }
            cur.isWord = true;
        }
        return root;
    }
}