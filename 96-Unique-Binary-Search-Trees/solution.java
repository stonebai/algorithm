public class Solution {
    public int numTrees(int n) {
        return count(1, n);
    }
    
    private int count(int start, int end) {
        if (start == end) {
            return 1;
        }
        int res = 0;
        res += count(start + 1, end);
        res += count(start, end - 1);
        for (int i = start + 1;i < end;i++) {
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            res += left * right;
        }
        return res;
    }
}