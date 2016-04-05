public class Solution {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for(int i=end;i>=0;i--) {
            if(i+nums[i]>=end) end = i;
        }
        return end == 0;
    }
}