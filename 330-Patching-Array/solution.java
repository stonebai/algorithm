public class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        int i = 0;
        int bound = 1;
        int count = 0;
        while (bound <= n) {
            if (i < nums.length && nums[i] <= bound && nums[i] + count >= bound) {
                count += nums[i++];
            } else {
                count += bound;
                res++;
            }
            bound = count + 1;
        }
        return res;
    }
}