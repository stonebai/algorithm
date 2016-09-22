public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        return k * helper(n - 1, k, false);
    }
    
    private int helper(int n, int k, boolean same) {
        if (n == 0) {
            return 1;
        }
        if (same) {
            return (k - 1) * helper(n - 1, k, false);
        } else {
            return (k - 1) * helper(n - 1, k, false) + helper(n - 1, k, true);
        }
    }
}