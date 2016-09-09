public class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != 0) {
                swap(nums, i, p++);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}