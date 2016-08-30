public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return neg(x, -n);
        } else {
            return pos(x, n);
        }
    }
    
    private double neg(double x, int n) {
        double cur = x;
        int i = 1;
        while (i * 2 <= n) {
            i *= 2;
            cur *= cur;
        }
        return 1 / cur / pos(x, n - i);
    }
    
    private double pos(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double cur = x;
        int i = 1;
        while (i * 2 < n) {
            i *= 2;
            cur *= cur;
        }
        return cur * pos(x, n - i);
    }
}