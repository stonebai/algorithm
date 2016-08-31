public class Solution {
    public int getMoneyAmount(int n) {
        return helper(1, n);
    }
    
    private int helper(int lo, int hi) {
        if (lo >= hi) {
            return 0;
        } else if (hi == lo + 1) {
            return lo;
        } else if (hi == lo + 2) {
            return lo + 1;
        } else if (hi == lo + 3) {
            return 2 * lo + 2;
        } else if (hi == lo + 4) {
            return 2 * lo + 4;
        }
        int min = Integer.MAX_VALUE;
        for (int i = lo;i <= hi;i++) {
            int a = helper(lo, i - 1);
            int b = helper(i + 1, hi);
            int c = Math.max(a, b);
            min = Math.min(min, c + i);
        }
        System.out.println("lo: " + lo + "\thi: " + hi + "\tmin: " + min);
        return min;
    }
}