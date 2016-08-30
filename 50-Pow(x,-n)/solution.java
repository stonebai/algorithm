public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pos(x, -n);
        } else {
            return pos(x, n);
        }
    }
    
    private double pos(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double tmp = pos(x, n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            return tmp * tmp * x;
        }
    }
}