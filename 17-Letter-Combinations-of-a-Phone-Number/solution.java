public class Solution {
    
    private static Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
    
    static {
        map.put('2', Arrays.asList({'a', 'b', 'c'}));
        map.put('3', Arrays.asList({'d', 'e', 'f'}));
        map.put('4', Arrays.asList({'g', 'h', 'i'}));
        map.put('5', Arrays.asList({'j', 'k', 'l'}));
        map.put('6', Arrays.asList({'m', 'n', 'o'}));
        map.put('7', Arrays.asList({'p', 'q', 'r', 's'}));
        map.put('8', Arrays.asList({'t', 'u', 'v'}));
        map.put('9', Arrays.asList({'w', 'x', 'y', 'z'}));
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        res.add("");
        char[] chs = digits.toCharArray();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                List<Character> list = map.get(ch);
                List<String> tmp = new ArrayList<String>();
                for (Character c : list) {
                    for (String str : res) {
                        tmp.add(str + c);
                    }
                }
                res = tmp;
            }
        }
        return res;
    }
}