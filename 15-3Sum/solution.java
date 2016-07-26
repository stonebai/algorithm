public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++) {
            int a = i + 1, b = nums.length - 1;
            while (a < b) {
                int sum = nums[i] + nums[a] + nums[b];
                if (sum > 0) {
                    b--;
                    continue;
                } else if (sum < 0) {
                    a++;
                    continue;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[a]);
                    list.add(nums[b]);
                    res.add(list);
                    while (a < b && nums[a] == nums[a + 1]) a++;
                    while (a < b && nums[b] == nums[b - 1]) b--;
                    a++;
                    b--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}