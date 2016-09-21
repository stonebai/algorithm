public class Solution {
    
    private int maxLeft;
    private int maxRight;
    private int maxTop;
    private int maxBottom;
    
    public int minArea(char[][] image, int x, int y) {
        maxLeft = x;
        maxRight = x;
        maxTop = y;
        maxBottom = y;
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];
        dfs(image, x, y, visited);
        return (maxRight - maxLeft + 1) * (maxBottom - maxTop + 1);
    }
    
    private void dfs(char[][] image, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[x].length || image[i][j] != '1' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        maxLeft = Math.min(maxLeft, x);
        maxRight = Math.max(maxRight, x);
        maxTop = Math.min(maxTop, y);
        maxBottom = Math.max(maxBottom, y);
        dfs(image, x + 1, y, visited);
        dfs(image, x - 1, y, visited);
        dfs(image, x, y + 1, visited);
        dfs(image, x, y - 1, visited);
    }
}