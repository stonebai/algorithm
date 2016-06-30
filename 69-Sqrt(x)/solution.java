public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int lo = 1, hi = x;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            long tmp = (long)mid * mid;
            if (tmp < x) {
                lo = mid;
            } else if (tmp > x) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        if ((long)hi * hi < x) {
            return hi;
        } else {
            return lo;
        }
    }
}