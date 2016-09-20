public class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0;i < chs.length;i++) {
            if (map.containsKey(chs[i])) {
                int index = map.get(chs[i]);
                if (index == sb.size() - 1) {
                    continue;
                }
                char ch = sb.charAt(index + 1);
                if (ch < chs[i]) {
                    sb.deleteCharAt(index);
                    sb.append(chs[i]);
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        char key = entry.getKey();
                        int value = entry.getValue();
                        if (value > index) {
                            entry.setValue(value - 1);
                        }
                    }
                    map.put(chs[i], sb.size() - 1);
                }
            } else {
                sb.append(chs[i]);
                map.put(chs[i], sb.size() - 1);
            }
        }
        return sb.toString();
    }
}