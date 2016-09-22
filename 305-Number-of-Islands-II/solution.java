public class Solution {
    
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] uf = initialize(m, n);
        List<Integer> res = new ArrayList<Integer>();
        int total = 0;
        for (int[] position : positions) {
            total += add(uf, position[0], position[1], m, n);
            res.add(total);
        }
        return res;
    }
    
    private int add(int[] uf, int x, int y, int m, int n) {
        int res = 1;
        int t = x * n + y;
        if (uf[t] != -1) {
            return 0;
        } else {
            uf[t] = t;
        }
        for (int[] dir : dirs) {
            int a = x + dir[0];
            int b = y + dir[0];
            if (a >= 0 && b >= 0 && a < m && b < n) {
                int i = a * n + b;
                if (uf[i] != -1) {
                    r = root(uf, i);
                    if (r != t) {
                        uf[r] = t;
                        res--;
                    }
                }
            }
        }
        return res;
    }
    
    private int root(int[] uf, int i) {
        while (i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
    
    private int[] initialize(int m, int n) {
        int[] uf = new int[m * n];
        for (int i = 0;i < uf.length;i++) {
            uf[i] = -1;
        }
        return uf;
    }
}