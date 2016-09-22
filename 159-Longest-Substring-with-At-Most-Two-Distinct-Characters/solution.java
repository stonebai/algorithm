public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = 0;
        while (j < chs.length) {
            if (map.containsKey(chs[j])) {
                map.put(chs[j], map.get(chs[j]) + 1);
            } else {
                if (map.size() == 2) {
                    res = Math.max(res, j - i);
                    while (true) {
                        int count = map.get(chs[i]) - 1;
                        if (count == 0) {
                            map.remove(chs[i++]);
                            break;
                        } else {
                            map.put(chs[i++], count);
                        }
                    }
                }
                map.put(chs[j], 1);
            }
            j++;
        }
        return Math.max(res, j - i);
    }
}