public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (isPalindrom(s)) {
            List<String> list = new ArrayList<String>();
            list.add(s);
            res.add(list);
        }
        for (int i = s.length() - 1;i > 0;i--) {
            String suf = s.substring(i);
            if (isPalindrome(suf)) {
                List<List<String>> lists = partition(s.substring(0, i));
                for (List<String> list : lists) {
                    list.add(suf);
                    res.add(list);
                }
            }
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
}