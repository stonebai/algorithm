public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k + 1;
        while (true) {
            int index = partition(nums, lo, hi);
            if (index > k) {
                hi = index - 1;
            } else if (index < k) {
                lo = index + 1;
            } else {
                return nums[k];
            }
        }
    }
    
    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int mid = lo + (hi - lo) / 2;
        int pivot = nums[mid];
        int pivotIndex = lo;
        swap(nums, lo, mid);
        while(true) {
            while(lo < hi && nums[hi] >= pivot) hi--;
            while(lo < hi && nums[lo] <= pivot) lo++;
            if (lo >= hi) break;
            swap(nums, lo++, hi--);
        }
        swap(nums, hi, pivotIndex);
        return hi;
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}