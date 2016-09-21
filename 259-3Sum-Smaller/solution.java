public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0;i < nums.length - 2;i++) {
            for (int j = i + 1;j < nums.length - 1;j++) {
                for (int k = j + 1;k < nums.length;k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}