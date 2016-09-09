public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] res = initialize(n);
        for (int[] edge : edges) {
            if (!union(res, edge[0], edge[1])) {
                return false;
            }
        }
        return edges.length == n - 1;
    }
    
    private boolean union(int[] res, int i, int j) {
        int rootI = findRoot(res, i);
        int rootJ = findRoot(res, j);
        if (rootI == rootJ) {
            return false;
        }
        if (rootI > rootJ) {
            res[rootI] = rootJ;
        } else {
            res[rootJ] = rootI;
        }
        return true;
    }
    
    private int findRoot(int[] res, int i) {
        while (res[i] != i) {
            i = res[i];
        }
        return i;
    }
    
    private int[] initialize(int n) {
        int[] res = new int[n];
        for (int i = 0;i < res.length;i++) {
            res[i] = i;
        }
        return res;
    }
}