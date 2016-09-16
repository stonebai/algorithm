public class Solution {
    public int longestValidParentheses(String s) {
        char[] chs = s.toCharArray();
        Stack<Integer> ids = new Stack<Integer>();
        Stack<Character> chs = new Stack<Integer>();
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] == '(') {
                ids.push(i);
                chs.push('(');
            }
            if (chs[i] == ')') {
                if (!chs.isEmpty() && chs.peek() == '(') {
                    chs.pop();
                    ids.pop();
                } else {
                    chs.push(')');
                    ids.push(i);
                }
            }
        }
        if (ids.isEmpty()) {
            return chs.length;
        }
        int end = chs.length;
        int res = 0;
        while (!ids.isEmpty()) {
            int start = ids.pop();
            int len = end - start - 1;
            res = Math.max(len, res);
            end = start;
        }
        return res;
    }
}