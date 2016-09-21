public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0;i < nums.length - 2;i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp >= target) {
                    right--;
                } else {
                    res += right - left;
                    left++;
                }
            }
        }
        return res;
    }
}