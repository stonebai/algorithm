public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        char[] nums1 = num1.toCharArray(), nums2 = num2.toCharArray();
        int k = m + n;
        int[] nums = new int[k];
        k -= 2;
        for (int i = nums1.length - 1;i >= 0;i--) {
            for (int j = nums2.length - 1;j >= 0;j--) {
                int cur = (nums1[i] - '0') * (nums2[j] - '0');
                add(nums, k - (i + j), cur);
                System.out.println(Arrays.toString(nums));
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = nums.length - 1;
        while (i >= 0 && nums[i] == 0) i--;
        for (;i >= 0;i--) {
            sb.append(nums[i]);
        }
        if (sb.length() == 0) return "0";
        else return sb.toString();
    }
    
    private void add(int[] nums, int i, int num) {
        nums[i] += num;
        if (nums[i] > 9) {
            add(nums, i + 1, nums[i] / 10);
            nums[i] = nums[i] % 10;
        }
    }
}