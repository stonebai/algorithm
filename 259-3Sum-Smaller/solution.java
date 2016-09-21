public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            while (j < nums.length - 1) {
                int k = j + 1;
                while (k < nums.length) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (tmp < target) {
                        res++;
                    }
                    k++;
                }
                j++;
            }
            // while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            //     i++;
            // }
            i++;
        }
        return res;
    }
}