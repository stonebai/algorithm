public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, new ArrayList<Integer>(), new HashSet<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> path, Set<Integer> visited, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
        } else {
            for (int num : nums) {
                if (!visited.contains(num)) {
                    path.add(num);
                    visited.add(num);
                    helper(nums, path, visited, res);
                    visited.remove(num);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}