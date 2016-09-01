public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        int res = 0;
        for (int num : nums) {
            res += combinationSum4(nums, target - num);
        }
        return res;
    }
}