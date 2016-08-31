public class Solution {
    public int firstUniqChar(String s) {
        Set<Character> dup = new HashSet<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chs = s.toCharArray();
        for (int i = 0;i < chs.length;i++) {
            if (dup.contains(chs[i])) {
                continue;
            }
            if (map.containsKey(chs[i])) {
                map.remove(chs[i]);
                dup.add(chs[i]);
                continue;
            }
            map.put(chs[i], i);
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res = Math.min(res, entry.getValue());
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}