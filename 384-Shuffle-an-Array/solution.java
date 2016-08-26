public class Solution {
    
    private int[] nums;
    private int[] shuffles;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.shuffles = Arrays.copyOf(nums, nums.length);
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0;i < shuffles.length;i++) {
            int index = this.random.nextInt(shuffles.length);
            swap(this.shuffles, i, index);
        }
        return this.shuffles;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */