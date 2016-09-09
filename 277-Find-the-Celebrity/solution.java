/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] dp = new boolean[n];
        for (int i = 0;i < n;i++) {
            if (dp[i]) {
                continue;
            }
            for (int j = 0;j < n;j++) {
                if (i == j) {
                    continue;
                }
                if (knows(j, i)) {
                    dp[j] = true;
                } else {
                    dp[i] = true;
                    break;
                }
            }
            if (!dp[i]) {
                for (int j = 0;j < n;j++) {
                    if (i == j) {
                        continue;
                    }
                    if (knows(i, j)) {
                        dp[i] = true;
                        break;
                    } else {
                        dp[j] = true;
                    }
                }
                if (!dp[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}