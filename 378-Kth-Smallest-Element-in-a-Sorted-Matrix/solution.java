public class Solution {
    
    static class Node implements Comparable<Node> {
        int val;
        int x;
        int y;
        
        Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        pq.offer(new Node(matrix[0][0], 0, 0));
        Node cur = null;
        while (k > 0) {
            cur = pq.poll();
            if (cur.x < matrix.length && cur.y + 1 < matrix[cur.x].length && !visited[cur.x][cur.y + 1]) {
                visited[cur.x][cur.y + 1] = true;
                pq.offer(new Node(matrix[cur.x][cur.y + 1], cur.x, cur.y + 1));
            }
            if (cur.x + 1 < matrix.length && cur.y < matrix[cur.x + 1].length && !visited[cur.x + 1][cur.y]) {
                visited[cur.x + 1][cur.y] = true;
                pq.offer(new Node(matrix[cur.x + 1][cur.y], cur.x + 1, cur.y));
            }
            k--;
        }
        return cur.val;
    }
}