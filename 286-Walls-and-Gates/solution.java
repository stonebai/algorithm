public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0;i < rooms.length;i++) {
            for (int j = 0;j < rooms[i].length;j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i + 1, j, 1);
                    dfs(rooms, i - 1, j, 1);
                    dfs(rooms, i, j + 1, 1);
                    dfs(rooms, i, j - 1, 1);   
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int val) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] <= val) {
            return;
        }
        rooms[i][j] = val;
        dfs(rooms, i + 1, j, val + 1);
        dfs(rooms, i - 1, j, val + 1);
        dfs(rooms, i, j + 1, val + 1);
        dfs(rooms, i, j - 1, val + 1);
    }
}