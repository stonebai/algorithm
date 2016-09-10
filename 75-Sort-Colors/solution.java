public class Solution {
    public void sortColors(int[] nums) {
        int pos = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == 0) {
                swap(nums, i, pos++);
            }
        }
        pos = nums.length - 1;
        for (int i = nums.length - 1;i >= 0;i--) {
            if (nums[i] == 2) {
                swap(nums, i, pos--);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}