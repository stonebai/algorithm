public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] uf = new int[n];
        for (int i = 0;i < n;i++) {
            uf[i] = i;
        }
        int count = n;
        for (int[] edge : edges) {
            if (!isConnected(uf, edge[0], edge[1])) {
                union(uf, edge[0], edge[1]);
                count--;
            }
        }
        return count;
    }
    
    private void union(int[] uf, int i, int j) {
        int rootI = root(uf, i);
        int rootJ = root(uf, j);
        uf[rootI] = rootJ;
    }
    
    private int root(int[] uf, int i) {
        while (i != uf[i]) {
            i = uf[i];
        }
        return i;
    }
    
    private boolean isConnected(int[] uf, int i, int j) {
        int rootI = root(uf, i);
        int rootJ = root(uf, j);
        return rootI == rootJ;
    }
}