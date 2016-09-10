public class Solution {
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
        int i = x * n + y;
        int up = -1;
        if (i >= n) {
            up = i - n;
            if (uf[up] == -1) {
                up = -1;
            }
        }
        int left = -1;
        if (i % n != 0) {
            left = i - 1;
            if (uf[left] == -1) {
                left = -1;
            }
        }
        int right = -1;
        if (i % n != n - 1) {
            right = i + 1;
            if (uf[right] == -1) {
                right = -1;
            }
        }
        int down = -1;
        if (i < (m - 1) * n) {
            down = i + n;
            if (uf[down] == -1) {
                down = -1;
            }
        }
        int count = 0;
        if (up != -1) {
            int rootUp = root(uf, up);
            count -= union(uf, rootUp, left);
            count -= union(uf, rootUp, right);
            count -= union(uf, rootUp, down);
            union(uf, rootUp, i);
        } else {
            if (left != -1) {
                int rootLeft = root(uf, left);
                count -= union(uf, rootLeft, right);
                count -= union(uf, rootLeft, down);
                union(uf, rootLeft, i);
            } else {
                if (right != -1) {
                    int rootRight = root(uf, right);
                    count -= union(uf, rootRight, down);
                    union(uf, rootRight, i);
                } else {
                    if (down != -1) {
                        int rootDown = root(uf, down);
                        union(uf, rootDown, i);
                    } else {
                        uf[i] = i;
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private int union(int[] uf, int root, int p) {
        if (p != -1) {
            rootP = root(uf, p);
            uf[rootP] = root;
            return 1;
        } else {
            return 0;
        }
    }
    
    private int root(int[] uf, int i) {
        while (i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
    
    private boolean isConnected(int[] uf, int i, int j) {
        int rootI = root(uf, i);
        int rootJ = root(uf, j);
        return rootI == rootJ;
    }
    
    private int[] initialize(int m, int n) {
        int[] uf = new int[m * n];
        for (int i = 0;i < uf.length;i++) {
            uf[i] = -1;
        }
        return uf;
    }
}