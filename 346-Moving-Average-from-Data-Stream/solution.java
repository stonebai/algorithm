public class MovingAverage {

    private int size;
    private int count;
    private double res;
    private Deque<Integer> q;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.count = 0;
        this.res = 0;
        this.q = new ArrayDeque<Integer>();
    }
    
    public double next(int val) {
        if (count < size) {
            q.offer(val);
            res = (res * count + val) / (count + 1);
            count++;
        } else {
            int t = q.poll();
            res = (res * count - t + val) / count;
            q.offer(val);
        }
        return res;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */