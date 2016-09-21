public class Solution {
    
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        char[] chs = new char[n];
        helper(chs, 0, res);
        return res;
    }
    
    private void helper(char[] chs, int i, List<String> res) {
        int j = chs.length - i - 1;
        if (i == j) {
            chs[i] = '0';
            res.add(new String(chs));
            chs[i] = '1';
            res.add(new String(chs));
            chs[i] = '8';
            res.add(new String(chs));
        } else if (i > j) {
            res.add(new String(chs));
        } else {
            if (i != 0) {
                chs[i] = '0';
                chs[j] = '0';
                helper(chs, i + 1, res);
            }
            chs[i] = '1';
            chs[j] = '1';
            helper(chs, i + 1, res);
            chs[i] = '6';
            chs[j] = '9';
            helper(chs, i + 1, res);
            chs[i] = '9';
            chs[j] = '6';
            helper(chs, i + 1, res);
            chs[i] = '8';
            chs[j] = '8';
            helper(chs, i + 1, res);
        }
    }
}