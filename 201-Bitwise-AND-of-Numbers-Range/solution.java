public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        for (int i = m + 1;i <= n;i++) {
            m &= i;
        }
        return m;
    }
}