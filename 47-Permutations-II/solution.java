public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            Set<List<Integer>> lists = new HashSet<List<Integer>>();
            for (List<Integer> list : res) {
                for (int i = 0;i < list.size();i++) {
                    if (list.get(i) != num) {
                        list.add(i, num);
                        lists.add(new ArrayList<Integer>(list));
                        list.remove(i);
                    }
                }
                list.add(num);
                lists.add(list);
            }
            res = new ArrayList<List<Integer>>(lists);
        }
        // Collections.sort(res, new Comparator<List<Integer>>() {
        //     @Override
        //     public int compare(List<Integer> a, List<Integer> b) {
        //         int i = 0;
        //         while (i < a.size() && a.get(i) == b.get(i)) i++;
        //         if (i == a.size()) return 0;
        //         else return a.get(i) - b.get(i);
        //     }
        // });
        return res;
    }
}