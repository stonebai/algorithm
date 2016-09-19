public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int i = 0, j = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (j < chs.length) {
            if (!map.containsKey(chs[j])) {
                if (k > 0) {
                    k--;
                } else {
                    res = Math.max(res, j - i);
                    while (true) {
                        int num = map.get(chs[i]) - 1;
                        if (num == 0) {
                            map.remove(chs[i++]);
                            break;
                        }
                        map.put(chs[i++], num);
                    }
                }
                map.put(chs[j], 1);
            } else {
                map.put(chs[j], map.get(chs[j]) + 1);
            }
            j++;
        }
        return Math.max(res, j - i);
    }
}