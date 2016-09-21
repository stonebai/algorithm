public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        if (stones[0] != 0) {
            return false;
        }
        if (stones.length == 1) {
            return true;
        }
        if (stones[1] != 1) {
            return false;
        }
        boolean[][] dp = new boolean[stones.length][stones.length];
        return helper(stones, 2, 1, dp);
    }
    
    private boolean helper(int[] stones, int pos, int jump, boolean[][] dp) {
        if (pos >= stones.length) {
            return true;
        }
        if (dp[pos][jump]) {
            return false;
        }
        dp[pos][jump] = true;
        int lo = stones[pos - 1] + jump - 1;
        int hi = stones[pos - 1] + jump + 1;
        boolean res = false;
        for (int i = pos;i < stones.length;i++) {
            if (stones[i] > hi) {
                break;
            } else if (stones[i] <= hi && stones[i] >= lo) {
                if (helper(stones, i + 1, stones[i] - stones[pos - 1], dp)) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}