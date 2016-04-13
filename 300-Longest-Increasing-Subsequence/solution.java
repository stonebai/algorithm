public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        List<Integer> list = new LinkedList<Integer>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++) {
            int num = list.get(list.size()-1);
            if(num<nums[i]) {
                list.add(nums[i]);
            }
            else if(num>nums[i]) {
                int index = findLeastLarger(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
    
    private int findLeastLarger(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        while(start<end) {
            int mid = start + (end-start) / 2;
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
        return start;
    }
}