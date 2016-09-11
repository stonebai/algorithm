public class Solution {
    
    static class Node {
        
        int[] count;
        
        Node(String s) {
            this.count = new int[26];
            for (char ch : s.toCharArray()) {
                this.count[ch - 'a']++;
            }
        }
        
        @Override
        public int hashCode() {
            return Arrays.hashCode(this.count);
        }
        
        @Override
        public boolean equals(Object o) {
            return Arrays.equals(this.count, ((Node) o).count);
        }
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<Node, List<String>> map = new HashMap<Node, List<String>>();
        for (String str : strs) {
            Node key = new Node(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}