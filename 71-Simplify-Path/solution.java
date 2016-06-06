public class Solution {
    public String simplifyPath(String path) {
        if (path == null) return "";
        String[] split = path.split("/");
        Deque<String> deque = new LinkedList<String>();
        for (String str : split) {
            if (str.length() == 0 || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                deque.pollFirst();
            } else {
                deque.offerFirst(str);
            }
        }
        
        if (deque.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()) {
                sb.append("/" + deque.pollLast());
            }
            return sb.toString();
        }
    }
}