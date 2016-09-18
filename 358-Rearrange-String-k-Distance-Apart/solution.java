public class Solution {
    
    static class Node {
        char ch;
        int count;
        
        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String rearrangeString(String str, int k) {
        if (k <= 1) {
            return str;
        }
        char[] res = new char[str.length()];
        Queue<Node> q = preprocess(str);
        Map<Character, Node> map = new HashMap<Character, Node>();
        for (int i = 0;i < res.length;i++) {
            if (i >= k) {
                char key = res[i - k];
                if (map.containsKey(key)) {
                    q.offer(map.remove(key));
                }
            }
            if (q.isEmpty()) {
                return "";
            }
            Node node = q.poll();
            res[i] = node.ch;
            node.count--;
            if (node.count > 0) {
                map.put(node.ch, node);
            }
        }
        return new String(res);
    }
    
    private Queue<Node> preprocess(String str) {
        char[] chs = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        Queue<Node> q = new PriorityQueue<Node>(100, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return b.count - a.count;
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            q.offer(new Node(entry.getKey(), entry.getValue()));
        }
        return q;
    }
}