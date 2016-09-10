public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(s);
        while (!q.isEmpty()) {
            String s = q.poll();
            if (wordDict.contains(s)) {
                return true;
            }
            for (int i = 1;i < s.length();i++) {
                if (wordDict.contains(s.substring(0, i))) {
                    q.offer(s.substring(i));
                }
            }
        }
        return false;
    }
}