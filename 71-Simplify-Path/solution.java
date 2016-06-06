public class Solution {
    public String simplifyPath(String path) {
        if (path == null) return "";
        String[] split = path.split("/");
        Deque<String> deque = new LinkedList<String>();
        for (String str : split) {
            if (str.length() == 0 || str.equals(".")) {
                continue;
            } else if (str.equals("..") {
                deque.pop();
            } else {
                deque.push(str);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append("/" + deque.poll());
        }
        return sb.toString();
    }
}