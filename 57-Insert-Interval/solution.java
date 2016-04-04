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
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if(a.start!=b.start) {
                    return a.start - b.start;
                }
                else {
                    return a.end - b.end;
                }
            }
        });
        for(int i=0;i<intervals.size();i++) {
            Interval tmp = intervals.get(i);
            if(tmp.end<newInterval.start) continue;
            if(tmp.start>newInterval.end) {
                intervals.add(i, newInterval);
                return intervals;
            }
            intervals.remove(i);
            i--;
            newInterval.start = Math.min(newInterval.start, tmp.start);
            newInterval.end = Math.max(newInterval.end, tmp.end);
        }
        intervals.add(newInterval);
        return intervals;
    }
}