public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] distances = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j, distances, visited);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (grid[i][j] == 0 && distances[i][j] != -1) {
                    res = Math.min(res, distances[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private void helper(int[][] grid, int x, int y, int[][] distances, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[] first = new int[2];
        first[0] = x;
        first[1] = y;
        q.offer(first);
        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0;k < size;k++) {
                int[] tmp = q.poll();
                int i = tmp[0];
                int j = tmp[1];
                if (distances[i][j] != -1) {
                    distances[i][j] += len;
                }
                if (i > 0 && grid[i - 1][j] == 0 && !visited[i - 1][j]) {
                    int[] t = new int[2];
                    t[0] = i - 1;
                    t[1] = j;
                    visited[t[0]][t[1]] = true;
                    q.offer(t);
                }
                if (j > 0 && grid[i][j - 1] == 0 && !visited[i][j - 1]) {
                    int[] t = new int[2];
                    t[0] = i;
                    t[1] = j - 1;
                    visited[t[0]][t[1]] = true;
                    q.offer(t);
                }
                if (i < grid.length - 1 && grid[i + 1][j] == 0 && !visited[i + 1][j]) {
                    int[] t = new int[2];
                    t[0] = i + 1;
                    t[1] = j;
                    visited[t[0]][t[1]] = true;
                    q.offer(t);
                }
                if (j < grid[i].length - 1 && grid[i][j + 1] == 0 && !visited[i][j + 1]) {
                    int[] t = new int[2];
                    t[0] = i;
                    t[1] = j + 1;
                    visited[t[0]][t[1]] = true;
                    q.offer(t);
                }
            }
            len++;
        }
        validate(grid, visited, distances);
    }
    
    private boolean validate(int[][] grid, boolean[][] visited, int[][] distances) {
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[i].length;j++) {
                if (grid[i][j] == 0) {
                    if (visited[i][j]) {
                        visited[i][j] = false;
                    } else {
                        distances[i][j] = -1;
                    }
                }
            }
        }
        return true;
    }
}