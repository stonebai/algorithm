public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        long prefixSum = 0;
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        map.put((long) 0, 1);
        for (int num : nums) {
            prefixSum += num;
            // cur - pre >= lower => pre <= cur - lower
            // cur - pre <= upper => pre >= cur - upper
            Map<Long, Integer> m = map.subMap(prefixSum - upper, true, prefixSum - lower, true);
            if (m != null) {
                for (Map.Entry<Long, Integer> entry : m.entrySet()) {
                    res += entry.getValue();
                }
            }
            if (map.containsKey(prefixSum)) {
                map.put(prefixSum, map.get(prefixSum) + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }
        return res;
    }
}