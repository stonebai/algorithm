public class Solution {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        Deque<Integer> nums = new ArrayDeque<Integer>();
        Deque<Character> signs = new ArrayDeque<Character>();
        int cur = 0;
        for (int i = 0;i< chs.length;i++) {
            if (chs[i] == '*' || chs[i] == '/') {
                char backup = chs[i++];
                int next = 0;
                for (;i < chs.length;i++) {
                    if (chs[i] >= '0' && chs[i] <= '9') {
                        next = next * 10 + chs[i] - '0';
                    } else if (chs[i] == ' ') {
                        continue;
                    } else {
                        break;
                    }
                }
                if (backup == '*') {
                    cur *= next;
                } else {
                    cur /= next;
                }
                i--;
            } else if (chs[i] == '+' || chs[i] == '-') {
                nums.offerLast(cur);
                signs.offerLast(chs[i]);
                cur = 0;
            } else if (chs[i] >= '0' && chs[i] <= '9') {
                cur = cur * 10 + chs[i] - '0';
            }
        }
        nums.offerLast(cur);
        int res = nums.pollFirst();
        while (!nums.isEmpty()) {
            char sign = signs.pollFirst();
            if (sign == '+') {
                res += nums.pollFirst();
            } else {
                res -= nums.pollFirst();
            }
        }
        return res;
    }
}