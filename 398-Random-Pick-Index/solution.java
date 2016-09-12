public class Solution {
    
    private int[] indexes;
    private int[] nums;
    private Random rand;

    // 4, 3, 3, 3, 2, 1
    // 0, 1, 2, 3, 4, 5
    // 5, 4, 1, 2, 3, 0

    public Solution(int[] nums) {
        this.rand = new Random();
        this.nums = nums;
        this.indexes = new int[nums.length];
        for (int i = 0;i < indexes.length;i++) {
            indexes[i] = i;
        }
        this.indexes = sort(nums, indexes, 0, nums.length - 1);
    }
    
    public int pick(int target) {
        int left = leftBinarySearch(this.nums, this.indexes, target);
        int right = rightBinarySearch(this.nums, this.indexes, target);
        int offset = this.rand.nextInt(right - left + 1);
        return this.indexes[left + offset];
    }
    
    private int rightBinarySearch(int[] nums, int[] indexes, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            int num = nums[indexes[mid]];
            if (num <= target) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
    
    private int leftBinarySearch(int[] nums, int[] indexes, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int num = nums[indexes[mid]];
            if (num < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j;
    }
    
    private int[] sort(int[] nums, int[] indexes, int start, int end) {
        int[] res = new int[end - start + 1];
        if (start == end) {
            res[0] = indexes[start];
            return res;
        }
        int mid = start + (end - start) / 2;
        int[] left = sort(nums, indexes, start, mid);
        int[] right = sort(nums, indexes, mid + 1, end);
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            int indexL = left[i];
            int indexR = right[j];
            if (nums[indexL] <= nums[indexR]) {
                res[k++] = indexL;
                i++;
            } else {
                res[k++] = indexR;
                j++;
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

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */