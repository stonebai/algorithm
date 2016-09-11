public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        if (n == 1) {
            return str;
        }
        for (int i = 1;i < n;i++) {
            List<Integer> list = count(str);
            str = say(list);
        }
        return str;
    }
    
    private List<Integer> count(String s) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0;i < s.length();i++) {
            char ch = s.charAt(i++);
            int len = 1;
            while (i < s.length() && ch == s.charAt(i)) {
                i++;
                len++;
            }
            list.add(len);
            list.add(ch - '0');
            i--;
        }
        return list;
    }
    
    private String say(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}