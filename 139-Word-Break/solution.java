public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        q.offer(s);
        while (!q.isEmpty()) {
            String str = q.poll();
            if (wordDict.contains(str)) {
                return true;
            }
            if (visited.contains(str)) {
                continue;
            } else {
                visited.add(str);
            }
            for (int i = 1;i < str.length();i++) {
                if (wordDict.contains(str.substring(0, i))) {
                    q.offer(str.substring(i));
                }
            }
        }
        return false;
    }
}