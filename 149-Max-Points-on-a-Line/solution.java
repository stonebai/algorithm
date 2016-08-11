/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int max = 0;
        for (int i = 0;i < points.length;i++) {
            for (int j = i + 1;j < points.length;j++) {
                double k = getK(points[i], points[j]);
                if (k == Double.MAX_VALUE) {
                    if (map.containsKey(k)) {
                        Map<Integer, Integer> m = map.get(k);
                        if (m.containsKey(points[i].x)) {
                            int num = m.get(points[i].x) + 1;
                            max = Math.max(max, num);
                            m.put(points[i].x, num);
                        } else {
                            max = Math.max(max, 1);
                            m.put(points[i].x, 1);
                        }
                    } else {
                        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                        max = Math.max(max, 1);
                        m.put(points[i].x, 1);
                        map.put(k, m);
                    }
                } else {
                    double b = getB(points[i], points[j]);
                    if (map.containsKey(k)) {
                        Map<Integer, Integer> m = map.get(k);
                        if (m.containsKey(b)) {
                            int num = m.get(b) + 1;
                            max = Math.max(max, num);
                            m.put(b, num);
                        } else {
                            max = Math.max(max, 1);
                            m.put(b, 1);
                        }
                    } else {
                        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                        max = Math.max(max, 1);
                        m.put(b, 1);
                        map.put(k, m);
                    }
                }
            }
        }
        return max;
    }
    
    private double getK(Point a, Point b) {
        if (a.x == b.x) {
            return Double.MAX_VALUE;
        }
        return ((double)(a.y - b.y)) / ((double)(a.x - b.x));
    }
    
    private double getB(Point a, Point b) {
        return ((double)(a.x * b.y - a.y * b.x)) / ((double)(a.x - b.x));
    }
}