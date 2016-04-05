public class Solution {
    // public int jump(int[] nums) {
    //     if(nums==null || nums.length==1)return 0;
    //     return 1+helper(nums,0,nums.length-1);
    // }
    
    // public int helper(int[]nums, int start, int target){
    //     if(start>=target)return 0;
    //     int min = Integer.MAX_VALUE;
    //     for(int i=1;i<nums[start];i++){
    //         int tmp=helper(nums, start+i, target);
    //         if(tmp<min)min=tmp;
    //     }
    //     return 1+min;
    // }
    public int jump(int[] nums){
        int target = nums.length-1;
        int count = 0;
        int start = 0;
        while(start<target && nums[start]==1){
            start++;
            count++;
        }
        for(int i=start;i<target;i++){
            if(i>0 && nums[i]<nums[i-1])continue;
            if(i+nums[i]>=target){
                count++;
                target = i;
                i=start-1;
            }
        }
        return count;
    }
}