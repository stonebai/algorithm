public class Solution {
    public void sortColors(int[] nums) {
        int pos = 0;
        int k = 3;
        for (int i = 0;i < k - 1;i++) {
            for (int j = pos;j < nums.length;j++) {
                if (nums[j] == i) {
                    swap(nums, j, pos++);
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}