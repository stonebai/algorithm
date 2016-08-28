public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = convert(magazine);
        char[] chs = ransomNote.toCharArray();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                if (num == 0) {
                    return false;
                } else {
                    map.put(ch, num - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    private Map<Character, Integer> convert(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chs = str.toCharArray();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }
}