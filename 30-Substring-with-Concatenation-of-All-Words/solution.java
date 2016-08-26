public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (words == null || words.length == 0) return res;
        int wlen = words[0].length();
        Map<String, Integer> map = createMap(words);
        for (int i = 0;i < wlen;i++) {
            Map<String, Integer> tMap = new HashMap<String, Integer>(map);
            int start = i;
            int count = words.length;
            for (int j = i;j <= s.length() - (count * wlen);j += wlen) {
                String str = s.substring(j, j + wlen);
                if (tMap.containsKey(str)) {
                    int num = tMap.get(str);
                    if (num > 0) {
                        tMap.put(str, num - 1);
                        count--;
                    } else {
                        while (true) {
                            String tmp = s.substring(start, start + wlen);
                            start += wlen;
                            if (tmp.equals(str)) {
                                break;
                            } else {
                                tMap.put(tmp, tMap.get(tmp) + 1);
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        res.add(start);
                        String tmp = s.substring(start, start + wlen);
                        start += wlen;
                        tMap.put(tmp, 1);
                        count = 1;
                    }
                } else {
                    tMap = new HashMap<String, Integer>(map);
                    start = j + wlen;
                    count = words.length;
                }
            }
        }
        return res;
    }
    
    private Map<String, Integer> createMap(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}