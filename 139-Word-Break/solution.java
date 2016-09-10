public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(s);
        while (!q.isEmpty()) {
            String str = q.poll();
            if (wordDict.contains(str)) {
                return true;
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