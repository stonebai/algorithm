public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] h = new int[col];
        int max = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(matrix[i][j]=='1') h[j] += 1;
                else h[j] = 0;
            }
            int count = histogram(h);
            if(count>max) max = count;
        }
        return max;
    }
    
    private int histogram(int[] h) {
        Stack<Integer> height = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<h.length;i++) {
            if(height.isEmpty() || h[i]>height.peek()) {
                height.push(h[i]);
                index.push(i);
            }
            else {
                int preIndex = i;
                while(!height.isEmpty() && h[i]<=height.peek()) {
                    int preHeight = height.pop();
                    preIndex = index.pop();
                    int count = (i - preIndex) * preHeight;
                    if(count>max) max = count;
                }
                height.push(h[i]);
                index.push(preIndex);
            }
        }
        while(!height.isEmpty()) {
            int preIndex = index.pop();
            int preHeight = height.pop();
            int count = (h.length - preIndex) * preHeight;
            if(count>max) max = count;
        }
        return max;
    }
}