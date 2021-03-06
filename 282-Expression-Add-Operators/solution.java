public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num.length() == 0) return res;
        char[] chs = num.toCharArray();
        helper(num, chs, 0, "", res, 0, target, 0);
        return res;
    }
    
    private void helper(String str, char[] chs, int index, String path, List<String> res, long val, int target, long mul) {
        if (index == chs.length) {
            if (val == target) {
                res.add(path);
            }
            return;
        }
        if (chs[index] == '0') {
            if (index == 0) {
                helper(str, chs, index + 1, String.valueOf(0), res, 0, target, 0);
            } else {
                helper(str, chs, index + 1, path + "+" + 0, res, val, target, 0);
                helper(str, chs, index + 1, path + "-" + 0, res, val, target, 0);
                helper(str, chs, index + 1, path + "*" + 0, res, val - mul, target, 0);
            }
        } else {
            for (int i = index;i < chs.length;i++) {
                String s = str.substring(index, i + 1);
                long num = Long.parseLong(s);
                if (index == 0) {
                    helper(str, chs, i + 1, s, res, num, target, num);
                } else {
                    helper(str, chs, i + 1, path + "+" + s, res, val + num, target, num);
                    helper(str, chs, i + 1, path + "-" + s, res, val - num, target, - num);
                    long m = mul * num;
                    helper(str, chs, i + 1, path + "*" + s, res, val - mul + m, target, m);
                }
            }
        }
    }
}