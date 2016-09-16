public class Solution {
    public int longestValidParentheses(String s) {
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int pre = 0;
        int cur = 0;
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] == '(') {
                stack.push(i);
            }
            if (chs[i] == ')') {
                if (!stack.isEmpty()) {
                    pre = Math.max(pre, cur);
                    cur = 0;
                } else {
                    int index = stack.pop();
                    cur = i - index + 1;
                }
            }
        }
        return Math.max(pre, cur);
    }
}