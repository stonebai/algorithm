class MedianFinder {

    TreeMap<Integer, Integer> left = new TreeMap<Integer, Integer>();
    TreeMap<Integer, Integer> right = new TreeMap<Integer, Integer>();
    int lcount = 0;
    int rcount = 0;
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(lcount==0 && rcount==0) {
            left.put(num, 1);
            lcount++;
        }
        else {
            Integer leftMax = left.lastKey();
            if(num>leftMax) {
                put(num, right);
                rcount++;
            }
            else {
                put(num, left);
                lcount++;
            }
        }
        while(lcount-rcount>1) {
            Map.Entry<Integer, Integer> entry = left.lastEntry();
            int key = entry.getKey();
            int value = entry.getValue();
            if(value==1) left.remove(key);
            else left.put(key, value - 1);
            lcount--;
            put(key, right);
            rcount++;
        }
        while(rcount-lcount>1) {
            Map.Entry<Integer, Integer> entry = right.firstEntry();
            int key = entry.getKey();
            int value = entry.getValue();
            if(value==1) right.remove(key);
            else right.put(key, value - 1);
            rcount--;
            put(key, left);
            lcount++;
        }
    }
    
    private void put(int num, TreeMap<Integer, Integer> map) {
        if(map.containsKey(num)) {
            int count = map.get(num);
            map.put(num, count+1);
        }
        else {
            map.put(num, 1);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(lcount>rcount) {
            return (double)left.lastKey();
        }
        else if(rcount>lcount) {
            return (double) right.firstKey();
        }
        else {
            return (double)(left.lastKey() + right.firstKey()) / 2.0;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();