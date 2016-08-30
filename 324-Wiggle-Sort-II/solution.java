public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int first = findKLargest(nums, nums.length / 2);
        int[] array = new int[nums.length];
        array[0] = nums[first];
        int p = 1, q = 2;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] > array[0]) {
                array[p] = nums[i];
                p += 2;
            } else {
                array[q] = nums[i];
                q += 2;
            }
        }
        for (int i = 0;i < nums.length;i++) {
            nums[i] = array[i];
        }
    }
    
    private int findKLargest(int[] nums, int k) {
        k--;
        int start = 0, end = nums.length - 1;
        while (true) {
            int index = partition(nums, start, end);
            if (index > k) {
                end = index - 1;
            } else if (index < k) {
                start = index + 1;
            } else {
                return index;
            }
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start + 1, j = end;
        while (i < j) {
            while (i < j && nums[i] <= pivot) i++;
            while (i < j && nums[j] >= pivot) j--;
            if (i == j) break;
            swap(nums, i++, j--);
        }
        if (nums[j] < pivot) {
            swap(nums, start, j);
        }
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}