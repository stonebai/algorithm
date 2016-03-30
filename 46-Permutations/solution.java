public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }
    
    private List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(start==nums.length-1) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(nums[start]);
            res.add(list);
            return res;
        }
        List<List<Integer>> lists = permute(nums, start+1);
        for(List<Integer> list : lists) {
            for(int i=0;i<list.size();i++) {
                List<Integer> tmp = new LinkedList<Integer>(list);
                tmp.add(i, nums[start]);
                res.add(tmp);
            }
            List<Integer> tmp = new LinkedList<Integer>(list);
            tmp.add(nums[start]);
            res.add(tmp);
        }
        return res;
    }
}