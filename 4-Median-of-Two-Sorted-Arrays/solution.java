public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int k = total / 2;
            return ((double) findK(nums1, nums2, k) + (double) findK(nums1, nums2, k + 1)) / 2;
        } else {
            int k = (total + 1) / 2;
            return findK(nums1, nums2, k);
        }
    }
    
    private double findK(int[] nums1, int[] nums2, int k) {
        int i1 = 0, i2 = 0;
        while (k > 0) {
            int t = k == 1 ? 1 : k / 2;
            int r1 = 0, r2 = 0;
            if (i1 < 0) r1 = -1;
            else r1 = findK(nums1, i1, t);
            if (i2 < 0) r2 = -1;
            else r2 = findK(nums2, i2, t);
            if (r1 == -1) {
                int num = r2 - i2 + 1;
                k -= num;
                i2 = r2 + 1;
                i1 = -1;
            } else if (r2 == -1) {
                int num = r1 - i1 + 1;
                k -= num;
                i1 = r1 + 1;
                i2 = -1;
            } else {
                if (nums1[r1] <= nums2[r2]) {
                    int num = r1 - i1 + 1;
                    k -= num;
                    i1 = r1 + 1;
                } else {
                    int num = r2 - i2 + 1;
                    k -= num;
                    i2 = r2 + 1;
                }
            }
        }
        if (i1 > 0 && i2 > 0) {
            return Math.max(nums1[i1 - 1], nums2[i2 - 1]);
        } else if (i1 > 0) {
            return nums1[i1 - 1];
        } else {
            return nums2[i2 - 1];
        }
    }
    
    private int findK(int[] nums, int start, int k) {
        if (start == nums.length) {
            return -1;
        } else if (start + k > nums.length) {
            return nums.length - 1;
        } else {
            return start + k - 1;
        }
    }
}