public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0 || k==0) return false;
        Set<Integer> set = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int num : nums) {
            if(set.contains(num)) return true;
            if(set.size()==k) {
                int last = queue.poll();
                set.remove(last);
            }
            set.add(num);
            queue.offer(num);
        }
        return false;
    }
}