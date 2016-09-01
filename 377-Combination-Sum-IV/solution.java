public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target <= 0) return 0;
        return dfs(nums, target, new HashMap<Integer, Integer>());
    }
    
    private int dfs(int[] nums, int target, Map<Integer, Integer> dp) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int res = 0;
        for (int num : nums) {
            res += dfs(nums, target - num, dp);
        }
        dp.put(target, res);
        return res;
    }
}