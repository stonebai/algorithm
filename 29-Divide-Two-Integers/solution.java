public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        boolean sign = true;
        if (dividend < 0) {
            dividend = -dividend;
            sign = !sign;
        }
        if (divisor < 0) {
            divisor = -divisor;
            sign = !sign;
        }
        if (dividend < divisor) {
            return 0;
        }
        long result = 1;
        int backup = divisor;
        while (dividend > (long)divisor + divisor) {
            divisor += divisor;
            result += result;
        }
        result += divide(dividend - divisor, backup);
        if (!sign) {
            result = -result;
        }
        return Math.min(result, Integer.MAX_VALUE);
    }
}