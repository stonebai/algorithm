public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1;i <= 9;i++) {
            helper(i, n, res);
        }
        return res;
    }
    
    private void helper(int x, int n, List<Integer> res) {
        if (x > n) {
            return;
        }
        res.add(x);
        int start = x * 10;
        int end = start + 10;
        for (int i = start;i < end;i++) {
            helper(i, n, res);
        }
    }
}