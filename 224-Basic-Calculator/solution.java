public class Solution {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        int pre = 0;
        int cur = 0;
        boolean isPlus = true;
        Stack<Integer> sNum = new Stack<Integer>();
        Stack<Boolean> sSign = new Stack<Integer>();
        for (char ch : chs) {
            if (ch >= '0' && ch <= '9') {
                cur = cur * 10 + ch - '0';
            } else if (ch == '+') {
                if (isPlus) {
                    pre += cur;
                } else {
                    pre -= cur;
                }
                cur = 0;
                isPlus = true;
            } else if (ch == '-') {
                if (isPlus) {
                    pre += cur;
                } else {
                    pre -= cur;
                }
                cur = 0;
                isPlus = false;
            } else if (ch == '(') {
                sNum.push(pre);
                pre = 0;
                sSign.push(isPlus);
                isPlus = true;
            } else if (ch == ')') {
                if (isPlus) {
                    cur += pre;
                } else {
                    cur -= pre;
                }
                pre = sNum.pop();
                isPlus = sSign.pop();
            }
        }
        if (isPlus) {
            pre += cur;
        } else {
            pre -= cur;
        }
        return pre;
    }
}