public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d - c);
                    break;
                case "*":
                    int e = stack.pop();
                    int f = stack.pop();
                    stack.push(f * e);
                    break;
                case "/":
                    int g = stack.pop();
                    int h = stack.pop();
                    stack.push(h / g);
                    break;
                default:
                    int i = Integer.parseInt(token);
                    stack.push(i);
            }
        }
        return stack.pop();
    }
}