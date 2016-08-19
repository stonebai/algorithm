public class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = generateNums(n);
        for (int i = 1;i < k;i++) {
            nextPermutation(nums);
        }
        return toString(nums);
    }
    
    private int[] generateNums(int n) {
        int[] res = new int[n];
        for (int i = 1;i <= n;i++) {
            res[i - 1] = i;
        }
        return res;
    }
    
    private void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] < nums[i - 1]) i--;
        if (i == 0) return;
        for (int j = nums.length - 1;j >= i;j--) {
            if (nums[j] > nums[i - 1]) {
                swap(nums, i - 1, j);
                break;
            }
        }
        reverse(nums, i, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }
    
    private String toString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}