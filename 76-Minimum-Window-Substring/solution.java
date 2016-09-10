public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = preprocess(t);
        int len = t.length();
        int count = 0;
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                if (num > 0) {
                    map.put(ch, num - 1);
                    count++;
                } else {
                    char c = s.charAt(i++);
                    while (c != ch) {
                        if (map.containsKey(c)) {
                            map.put(c, map.get(c) + 1);
                            count--;
                            c = s.charAt(i++);
                        }
                    }
                }
            }
            j++;
            if (count == len) {
                char c = s.charAt(i);
                while (!map.containsKey(c)) {
                    c = s.charAt(++i);
                }
                int tmp = j - i;
                if (tmp < min) {
                    res = s.substring(i, j);
                    min = tmp;
                }
            }
        }
        return res;
    }
    
    private Map<Character, Integer> preprocess(String t) {
        Map<Character, Integer> res = new HashMap<Character, Integer>();
        for (int i = 0;i < t.length();i++) {
            char ch = t.charAt(i);
            if (res.containsKey(ch)) {
                res.put(ch, res.get(ch) + 1);
            } else {
                res.put(ch, 1);
            }
        }
        return res;
    }
}