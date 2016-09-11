public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        char[] chs = s.toCharArray();
        List<String> res = new ArrayList<String>();
        int count = count(chs);
        if (count == 0) {
            res.add(s);
            return res;
        }
        char target = '(';
        if (count < 0) {
            target = ')';
            count = -count;
        }
        List<Integer> list = findIndex(chs, target);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        combination(list, count, 0, new ArrayList<Integer>(), lists);
        for (List<Integer> l : lists) {
            int pre = 0;
            StringBuilder sb = new StringBuilder();
            for (int x : l) {
                sb.append(s.substring(pre, x));
                pre = x + 1;
            }
            if (x < s.length()) {
                sb.append(s.substring(x));
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    private void combination(List<Integer> list, int k, int pos, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        int left = k - path.size();
        for (int i = pos;i < list.size() - left + 1;i++) {
            path.add(list.get(i));
            combination(list, k, pos + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
    
    private List<Integer> findIndex(char[] chs, char target) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] == target) {
                while (chs[i] == target) {
                    i++;
                }
                res.add(i - 1);
            }
        }
        return res;
    }
    
    private int count(char[] chs) {
        int count = 0;
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] == '(') {
                count++;
            }
            if (chs[i] == ')') {
                count--;
            }
        }
        return count;
    }
}