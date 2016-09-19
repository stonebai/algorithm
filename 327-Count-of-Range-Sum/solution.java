public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int[] idx = new int[nums.length];
        for (int i = 0;i < idx.length;i++) {
            idx[i] = i;
        }
        idx = mergeSort(nums, idx, 0, nums.length - 1);
        int res = 0;
        for (int i = 0;i < idx.length;i++) {
            res = Math.max(res, i - idx[i]);
        }
        return res;
    }
    
    private int[] mergeSort(int[] nums, int[] indexes, int lo, int hi) {
        int[] res = new int[hi - lo + 1];
        if (lo == hi) {
            res[0] = indexes[lo];
            return res;
        }
        int mid = lo + (hi - lo) / 2;
        int[] left = mergeSort(nums, indexes, lo, mid);
        int[] right = mergeSort(nums, indexes, mid + 1, hi);
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            int idL = left[i];
            int idR = right[j];
            if (nums[idL] <= nums[idR]) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }
        while (i < left.length) {
            res[k++] = left[i++];
        }
        while (j < right.length) {
            res[k++] = right[j++];
        }
        return res;
    }
}