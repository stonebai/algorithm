public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            result[i++] = num;
        }
        return result;
    }
}