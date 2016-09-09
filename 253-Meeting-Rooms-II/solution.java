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
    
    private static class Node implements Comparable<Node> {
        int x;
        boolean isStart;
        
        Node(int x, boolean isStart) {
            this.x = x;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(Node o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                if (!this.isStart && !o.isStart) {
                    return 0;
                } else if (!this.isStart) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        Queue<Node> q = preprocess(intervals);
        int count = 0, res = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.isStart) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
    
    private Queue<Node> preprocess(Interval[] intervals) {
        Queue<Node> q = new PriorityQueue<Node>();
        for (Interval interval : intervals) {
            q.offer(new Node(interval.start, true));
            q.offer(new Node(interval.end, false));
        }
        return q;
    }
}