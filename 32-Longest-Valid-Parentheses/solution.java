public class Solution {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        Stack<Integer> ids = new Stack<Integer>();
        for (int i = 0;i < cs.length;i++) {
            if (cs[i] == '(') {
                ids.push(i);
            }
            if (cs[i] == ')') {
                if (!ids.isEmpty() && cs[ids.peek()] == '(') {
                    ids.pop();
                } else {
                    ids.push(i);
                }
            }
        }
        if (ids.isEmpty()) {
            return cs.length;
        }
        int end = cs.length;
        int res = 0;
        while (!ids.isEmpty()) {
            int start = ids.pop();
            int len = end - start - 1;
            res = Math.max(len, res);
            end = start;
        }
        res = Math.max(res, end);
        return res;
    }
}