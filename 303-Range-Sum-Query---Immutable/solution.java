public class NumArray {
    
    private int[] prefixSum;
    private int[] nums;

    public NumArray(int[] nums) {
        if(nums==null || nums.length==0) return;
        this.nums = nums;
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return prefixSum[j] - prefixSum[i] + nums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);