public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        boolean sign = true;
        long dd = dividend;
        if (dd < 0) {
            dd = -dd;
            sign = !sign;
        }
        long ds = divisor;
        if (ds < 0) {
            ds = -ds;
            sign = !sign;
        }
        long result = divide(dd, ds);
        if (!sign) {
            result = -result;
        }
        return (int) Math.min(result, Integer.MAX_VALUE);
    }
    
    private long divide(long dd, long ds) {
        if (dd < ds) {
            return 0;
        }
        long res = 1;
        long backup = ds;
        while (dd > ds + ds) {
            ds += ds;
            res += res;
        }
        res += divide(dd - ds, backup);
        return res;
    }
}