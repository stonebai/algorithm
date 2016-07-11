public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 4, res, new StringBuilder());
        return res;
    }
    
    private void helper(String s, int n, List<String> res, StringBuilder sb) {
        if (n == 0) {
            if (s.length() == 0) {
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());   
            }
            return;
        }
        if (s.length() > 3 * n || s.length() < n) {
            return;
        }
        for (int i = 1;i <= 3 && i <= s.length();i++) {
            StringBuilder tmp = new StringBuilder(sb.toString());
            String str = s.substring(0, i);
            Integer num = Integer.parseInt(str);
            if (num > 255 || (str.length() != 1 && num < Math.pow(10, (str.length() - 1)))) {
                continue;
            }
            tmp.append(str);
            tmp.append(".");
            helper(s.substring(i), n - 1, res, tmp);
        }
    }
}