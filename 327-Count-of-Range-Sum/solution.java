public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        int prefixSum = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(0);
        for (int num : nums) {
            prefixSum += num;
            // cur - pre >= lower => pre <= cur - lower
            // cur - pre <= upper => pre >= cur - upper
            Set<Integer> tmp = set.subSet(prefixSum - upper, true, prefixSum - lower, true);
            res += tmp.size();
            set.add(prefixSum);
        }
        return res;
    }
}