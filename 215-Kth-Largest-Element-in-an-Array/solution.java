public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k--;
        int i = 0, j = nums.length - 1;
        while (true) {
            int index = partition(nums, i, j);
            if (index > k) {
                j = index - 1;
            } else if (index < k) {
                i = index + 1;
            } else {
                return nums[index];
            }
        }
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int p = nums[lo];
        int i = lo + 1, j = hi;
        while (i < j) {
            while (i < j && nums[i] >= p) i++;
            while (i < j && nums[j] <= p) j--;
            if (i >= j) break;
            swap(nums, i++, j--);
        }
        if (i == j) {
            if (nums[i] >= p) {
                swap(nums, i, lo);
                return i;
            } else {
                swap(nums, i - 1, lo);
                return i - 1;
            }
        } else {
            swap(nums, j, lo);
            return j;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}