public class MedianFinder {
    
    private Queue<Integer> minQ = new PriorityQueue<Integer>();
    private Queue<Integer> maxQ = new PriorityQueue<Integer>(100, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    });
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minQ.isEmpty() || minQ.peek() <= num) {
            minQ.offer(num);
        } else {
            maxQ.offer(num);
        }
        while (maxQ.size() < minQ.size()) {
            maxQ.offer(minQ.poll());
        }
        while (minQ.size() < maxQ.size()) {
            minQ.offer(maxQ.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minQ.size() == maxQ.size()) {
            return (minQ.peek() + maxQ.peek()) / 2.0;
        } else {
            return minQ.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();