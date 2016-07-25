public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] indexes = new int[primes.length];
        for (int i = 0;i < indexes.length;i++) {
            indexes[i] = 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1;i < n;i++) {
            int min = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0;j < indexes.length;j++) {
                int tmp = dp[indexes[j]] * primes[j];
                if (tmp == min) {
                    list.add(j);
                }
                if (tmp < min) {
                    list.clear();
                    list.add(j);
                    min = tmp;
                }
            }
            for (int j = 0;j < list.size();j++) {
                indexes[list.get(j)]++;
            }
            dp[i] = min;
        }
        return dp[dp.length - 1];
    }
}