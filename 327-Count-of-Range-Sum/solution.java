public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        long prefixSum = 0;
        TreeSet<Long> set = new TreeSet<Long>();
        set.add(0);
        for (int num : nums) {
            prefixSum += num;
            // cur - pre >= lower => pre <= cur - lower
            // cur - pre <= upper => pre >= cur - upper
            Set<Long> tmp = set.subSet(prefixSum - upper, true, prefixSum - lower, true);
            res += tmp.size();
            set.add(prefixSum);
        }
        return res;
    }
}