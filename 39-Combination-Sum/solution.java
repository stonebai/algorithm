public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(candidates, target, 0, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] candidates, int target, int sum, int pos, List<Integer> path, List<List<Integer>> res) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = pos;i < candidates.length;i++) {
            path.add(candidates[i]);
            helper(candidates, target, sum + candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }
}