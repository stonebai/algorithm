public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, List<Integer>> map = helper(nums);
        Map<Integer, List<Integer>> visited = new HashMap<Integer, List<Integer>>();
        for (int num : nums) {
            List<Integer> tmp = getMaxCount(map, num, visited);
            if (tmp.size() > res.size()) {
                res = tmp;
            }
        }
        return res;
    }
    
    private List<Integer> getMaxCount(Map<Integer, List<Integer>> map, int num, Map<Integer, List<Integer>> visited) {
        if (visited.containsKey(num)) {
            return new ArrayList<Integer>(visited.get(num));
        }
        List<Integer> list = map.get(num);
        List<Integer> res = new ArrayList<Integer>();
        for (Integer i : list) {
            List<Integer> tmp = getMaxCount(map, i.intValue(), visited);
            if (tmp.size() > res.size()) {
                res = tmp;
            }
        }
        res.add(num);
        visited.put(num, res);
        return res;
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