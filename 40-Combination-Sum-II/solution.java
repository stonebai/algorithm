public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Array.sort(candidates);
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
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
            path.add(candidates[i]);
            helper(candidates, target, sum + candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}