public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        q.offer(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int k = 0;k < size;k++) {
                String str = q.poll();
                char[] chs = str.toCharArray();
                for (int i = 0;i < chs.length;i++) {
                    char tmp = chs[i];
                    for (char ch = 'a';ch <= 'z';ch++) {
                        chs[i] = ch;
                        String s = new String(chs);
                        if (s.equals(endWord)) {
                            return count + 1;
                        }
                        if (!visited.contains(s) && wordList.contains(s)) {
                            visited.add(s);
                            q.offer(s);
                        }
                    }
                    chs[i] = tmp;
                }
            }
        }
        return 0;
    }
}