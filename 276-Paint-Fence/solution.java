public class Solution {
    public int numWays(int n, int k) {
        return n * Math.pow(k, n - 1);
    }
}