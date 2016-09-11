/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }
        int index = bs(intervals, newInterval);
        if (index == intervals.size() - 1 && intervals.get(index).start < newInterval.start) {
            index++;
        }
        // merge forward
        if (index > 0) {
            Interval tmp = intervals.get(index - 1);
            if (tmp.end >= newInterval.start) {
                intervals.remove(--index);
                newInterval.start = tmp.start;
                newInterval.end = Math.max(newInterval.end, tmp.end);
            }
        }
        // merge backward
        while (index < intervals.size()) {
            Interval tmp = intervals.get(index);
            if (tmp.start <= newInterval.end) {
                intervals.remove(index);
                newInterval.end = Math.max(newInterval.end, tmp.end);
            } else {
                break;
            }
        }
        intervals.add(index, newInterval);
        return intervals;
    }
    
    private int bs(List<Interval> intervals, Interval newInterval) {
        int start = 0, end = intervals.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            Interval tmp = intervals.get(mid);
            if (tmp.start < newInterval.start) {
                start = mid + 1;
            } else if (tmp.start > newInterval.start) {
                end = mid;
            } else {
                return mid;
            }
        }
        return end;
    }
}