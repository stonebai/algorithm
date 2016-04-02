public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<2) return;
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int end = nums.length - 1, index = 0, start = end / 2;
        while(index<nums.length) {
            if(index%2==0) tmp[index] = nums[start--];
            else tmp[index] = nums[end--];
            index++;
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = tmp[i];
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}