public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0;i < size;i++) {
                List<Integer> list = new ArrayList<Integer>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}