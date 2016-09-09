/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    private Queue<Character> q = new LinkedList<Character>();
    
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n && !q.isEmpty()) {
            buf[index++] = q.poll();
        }
        if (index < n) {
            char[] chs = new char[4];
            while (index < n) {
                int num = read4(chs);
                int offset = 0;
                while (index < n && offset < num) {
                    buf[index++] = chs[offset++];
                }
                while (offset < num) {
                    q.offer(chs[offset++]);
                }
                if (num < 4) {
                    break;
                }
            }
        }
        return index;
    }
}