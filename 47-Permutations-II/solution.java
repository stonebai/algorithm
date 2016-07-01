public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        res.add(empty);
        for (int num : nums) {
            res = permute(res, num);
        }
        return res;
    }
    
    private List<List<Integer>> permute(List<List<Integer>> lists, int num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (List<Integer> list : lists) {
            for (int i = 0;i < list.size();i++) {
                if (list.get(i) == num) {
                    continue;
                }
                List<Integer> tmp = new ArrayList<Integer>(list);
                tmp.add(i, num);
                res.add(tmp);
            }
            if (list.get(list.size() - 1) == num) {
                List<Integer> tmp = new ArrayList<Integer>(list);
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }
}