public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0] && a[1] > b[1]) {
                    return 1;
                } else if (a[0] < b[0] && a[1] < b[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int[] dp = new int[envelopes.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1;i < envelopes.length;i++) {
            dp[i] = 1;
            for (int j = 0;j < i;j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}