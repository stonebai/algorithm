public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0;i < nums.length;i++) {
            for (int j = i + 1;j <= i + k;j++) {
                if (Math.abs(nums[i]-nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}