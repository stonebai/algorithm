public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            String key = sort(str);
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
    
    private String sort(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}