public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        map.put(0, -1);
        int max = 0;
        for (int i = 0;i < nums.length;i++) {
            sum += nums[i];
            int diff = sum - k;
            if (map.containsKey(diff)) {
                max = Math.max(max, i - map.get(diff));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}