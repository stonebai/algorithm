public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length];
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] == '(') {
                stack.push(i);
            } else if (chs[i] == ')') {
                if (!stack.isEmpty()) {
                    int index = stack.pop();
                    if (index > 0) {
                        dp[i] = i - index + 1 + dp[index - 1];
                    } else {
                        dp[i] = i - index + 1;
                    }
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}