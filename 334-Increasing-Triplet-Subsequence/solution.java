public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length<3) return false;
        List<Integer> list = new ArrayList<Integer>(nums.length);
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++) {
            int max = list.get(list.size()-1);
            if(nums[i]>max) {
                list.add(nums[i]);
            }
            else if(nums[i]<max) {
                int index = findLeastLargerOrEqual(list, nums[i]);
                list.set(index, nums[i]);
            }
            if(list.size()>=3) return true;
        }
        return false;
    }
    
    private int findLeastLargerOrEqual(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        while(start<end) {
            int mid = start + (end - start) / 2;
            int num = list.get(mid);
            if(num>target) {
                end = mid;
            }
            else if(num<target) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return end;
    }
}