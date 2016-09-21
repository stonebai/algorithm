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
        boolean[] dp = new boolean[stones.length];
        return helper(stones, 2, 2, dp);
    }
    
    private helper(int[] stones, int pos, int jump, boolean[] dp) {
        if (pos >= stones.length) {
            return true;
        }
        if (dp[pos]) {
            return false;
        }
        dp[pos] = true;
        boolean res = false;
        for (int i = pos;i < stones.length;i++) {
            if (stones[i] > jump + 1) {
                break;
            } else if (stones[i] >= jump - 1 && stones[i] <= jump + 1) {
                if (helper(stones, i + 1, stones[i] - pos + 1, dp)) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}