public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target <= 0) return 0;
        Arrays.sort(nums);
        return dfs(nums, target, new HashMap<Integer, Integer>());
    }
    
    private int dfs(int[] nums, int target, Map<Integer, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int res = 0;
        for (int num : nums) {
            int delta = target - num;
            if (delta > 0) {
                res += dfs(nums, target - num, dp);
            } else {
                if (delta == 0) {
                    res += 1;
                }
                break;
            }
        }
        dp.put(target, res);
        return res;
    }
}