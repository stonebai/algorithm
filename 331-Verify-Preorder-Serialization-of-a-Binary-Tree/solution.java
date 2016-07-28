public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for (String node : nodes) {
            if (node.equals("#")) {
                while (!stack.isEmpty()) {
                    if (stack.peek().equals("#")) {
                        if (stack.size() >= 2) {
                            stack.pop();
                            String str = stack.pop();
                            if (str.equals("#")) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        break;
                    }
                }
            }
            stack.push(node);
            System.out.println(stack.toString());
        }
        if (stack.size() == 1 && stack.peek().equals("#")) {
            return true;
        }
        return false;
    }
}