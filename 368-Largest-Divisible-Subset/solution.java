public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int max = 0;
        Map<Integer, List<Integer>> map = helper(nums);
        for (int num : nums) {
            List<Integer> tmp = new ArrayList<Integer>();
            int count = getMaxCount(map, num, tmp);
            if (count > max) {
                max = count;
                res = tmp;
            }
        }
        Collections.reverse(res);
        return res;
    }
    
    private int getMaxCount(Map<Integer, List<Integer>> map, int num, List<Integer> path) {
        int max = 0;
        List<Integer> list = map.get(num);
        List<Integer> l = new ArrayList<Integer>();
        for (Integer i : list) {
            List<Integer> tmp = new ArrayList<Integer>();
            int count = getMaxCount(map, i.intValue(), tmp);
            if (count > max) {
                max = count;
                l = tmp;
            }
        }
        path.add(num);
        path.addAll(l);
        return max + 1;
    }
    
    private Map<Integer, List<Integer>> helper(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> res = new HashMap<Integer, List<Integer>>();
        for (int i  = 0;i < nums.length;i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0;j < i;j++) {
                if (nums[i] % nums[j] == 0) {
                    list.add(nums[j]);
                }
            }
            res.put(nums[i], list);
        }
        return res;
    }
}