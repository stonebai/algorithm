public class Solution {
    public boolean canJump(int[] nums) {
        int far = 0, end = nums.length - 1;
        for(int i=0;i<end;i++) {
            if(i>far) return false;
            int tmp = i + nums[i];
            if(tmp>=end) return true;
            if(tmp>far) far = tmp;
        }
        return far>=end;
    }
}