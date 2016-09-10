public class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        Stack<Integer> nums = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        int num = 0;
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = num * 10 - '0' + chs[i];
            } else if (chs[i] == '[') {
                stack.push(sb);
                nums.push(num);
                sb = new StringBuilder();
                num = 0;
            } else if (chs[i] == ']') {
                int num = nums.pop();
                String str = repeat(sb.toString(), num);
                sb = stack.pop();
                sb.append(str);
                num = 0;
            } else {
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }
    
    private String repeat(String str, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < k;i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}