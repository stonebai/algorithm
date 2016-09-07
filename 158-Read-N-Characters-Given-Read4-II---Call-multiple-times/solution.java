/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    
    private Deque<Character> q = new ArrayDeque<Character>();
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n && !q.isEmpty()) {
            char ch = q.poll();
            buf[i++] = ch;
        }
        if (i < n) {
            char[] chs = new char[4];
            while (i < n) {
                int total = read4(chs);
                int count = 0;
                while (count < total && i < n) {
                    buf[i++] = chs[count++];
                }
                while (count < total) {
                    q.offer(chs[count++]);
                }
                if (total < 4) {
                    break;
                }
            }
        }
        return i;
    }
}