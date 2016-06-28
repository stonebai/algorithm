public class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long tmp = (long) mid * mid;
            if (tmp > num) {
                hi = mid - 1;
            } else if (tmp < num) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}