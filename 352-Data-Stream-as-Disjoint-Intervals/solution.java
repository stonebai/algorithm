/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    
    private Map<Integer, Interval> left;
    private Map<Integer, Interval> right;
    private List<Interval> list;
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.left = new HashMap<Integer, Interval>();
        this.right = new HashMap<Integer, Interval>();
        this.list = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        if (this.left.containsKey(val + 1) && this.right.containsKey(val - 1)) {
            Interval right = this.left.get(val + 1);
            Interval left = this.right.get(val - 1);
            this.right.remove(left.end);
            this.left.remove(right.start);
            delete(this.list, right);
            left.end = right.end;
            this.right.put(left.end, left);
        } else if (this.left.containsKey(val + 1)) {
            Interval right = this.left.get(val + 1);
            this.left.remove(right.start);
            right.start = val;
            this.left.put(val, right);
        } else if (this.right.containsKey(val - 1)) {
            Interval left = this.right.get(val - 1);
            this.right.remove(left.end);
            left.end = val;
            this.right.put(val, left);
        } else {
            Interval in = new Interval(val, val);
            this.left.put(val, in);
            this.right.put(val, in);
            add(this.list, in);
        }
    }
    
    public List<Interval> getIntervals() {
        return this.list;
    }
    
    private static void add(List<Interval> list, Interval in) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int tmp = list.get(mid).start;
            if (tmp < in.start) {
                start = mid + 1;
            } else if (tmp > in.start) {
                end = mid - 1;
            } else {
                list.add(start, in);
                return;
            }
        }
        System.out.println("start: " + start + "\tend: " + end);
        if (end == -1) {
            list.add(0, in);
        } else if (start == list.size()) {
            list.add(in);
        } else {
            list.add(start, in);
        }
    }
    
    private static void delete(List<Interval> list, Interval in) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int tmp = list.get(mid).start;
            if (tmp < in.start) {
                start = mid + 1;
            } else if (tmp > in.start) {
                end = mid - 1;
            } else {
                list.remove(mid);
            }
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */