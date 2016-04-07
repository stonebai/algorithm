public class Solution {
    
    class Node implements Comparable<Node> {
        int x;
        int y;
        int value;
        
        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int row = matrix.length - 1;
        int col = matrix[row].length - 1;
        boolean[][] visited = new boolean[row+1][col+1];
        visited[row][col] = true;
        pq.offer(new Node(row, col, matrix[row][col]));
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            if(tmp.value == target) return true;
            else if(tmp.value>target) {
                if(tmp.x>0 && !visited[tmp.x-1][tmp.y]) {
                    visited[tmp.x-1][tmp.y] = true;
                    pq.offer(new Node(tmp.x-1, tmp.y, matrix[tmp.x-1][tmp.y]));
                }
                if(tmp.y>0 && !visited[tmp.x][tmp.y-1]) {
                    visited[tmp.x][tmp.y-1] = true;
                    pq.offer(new Node(tmp.x, tmp.y-1, matrix[tmp.x][tmp.y-1]));
                }
            }
        }
        return false;
    }
}