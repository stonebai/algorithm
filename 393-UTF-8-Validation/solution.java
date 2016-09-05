public class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int len = count(data[0]);
        if (len != data.length) {
            return false;
        }
        for (int i = 1;i < data.length;i++) {
            if (!startsWith(data[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean startsWith(int num) {
        int x = 1 << 7;
        int y = 1 << 6;
        return (num & x) != 0 && (num & y) == 0;
    }
    
    private int count(int num) {
        int x = 1 << 7;
        int res = 1;
        while (true) {
            if (x & num != 0) {
                x = x >> 1;
                res++;
            } else {
                return res;
            }
            if (res > 4) {
                return -1;
            }
        }
    }
}