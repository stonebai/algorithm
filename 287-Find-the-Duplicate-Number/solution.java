public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int tmp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(tmp == nums[i]){
                return tmp;
            }
            else{
                tmp = nums[i];
            }
        }
        return tmp;
    }
}