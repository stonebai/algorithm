public class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : chs) {
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, count+1);
            }
            else {
                map.put(ch, 1);
            }
        }
        boolean oneChance = chs.length%2==1;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2==1) {
                if(oneChance) {
                    oneChance = false;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}