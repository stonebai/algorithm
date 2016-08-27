public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0;i < words.length;i++) {
            map.put(words[i], i);
        }
        for (int i = 0;i < words.length;i++) {
            map.remove(words[i]);
            for (int j = 0;j <= words[i].length();j++) {
                String str = words[i].substring(j);
                if (isPalindrome(str)) {
                    String tmp = new StringBuilder(words[i].substring(0, j)).reverse().toString();
                    if (map.containsKey(tmp)) {
                        save(res, i, map.get(tmp));
                    }
                }
            }
            for (int j = 1;j <= words[i].length();j++) {
                String str = words[i].substring(0, j);
                if (isPalindrome(str)) {
                    String tmp = new StringBuilder(words[i].substring(j)).reverse().toString();
                    if (map.containsKey(tmp)) {
                        save(res, map.get(tmp), i);
                    }
                }
            }
            map.put(words[i], i);
        }
        return res;
    }
    
    private boolean isPalindrome(String str) {
        char[] chs = str.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (chs[i++] != chs[j--]) {
                return false;
            }
        }
        return true;
    }
    
    private void save(List<List<Integer>> res, int a, int b) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(a);
        list.add(b);
        res.add(list);
    }
}