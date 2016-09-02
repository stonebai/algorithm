public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for (int i = 1;i < nums.length;i++) {
            update(list, nums[i]);
            if (list.size() == 3) return true;
        }
        return false;
    }
    
    private void update(List<Integer> list, int num) {
        int end = list.size() - 1;
        if (num > list.get(end)) {
            list.add(num);
            return;
        }
        int start = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) > num) {
                end = mid;
            } else if (list.get(mid) < num) {
                start = mid + 1;
            } else {
                return;
            }
        }
        list.set(start, num);
    }
}