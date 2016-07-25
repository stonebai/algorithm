public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (k <= 0) {
            return res;
        }
        int i = 0, j = 0;
        while (k > 0) {
            k--;
            int[] tmp = new int[2];
            tmp[0] = nums1[i];
            tmp[1] = nums2[j];
            res.add(tmp);
            if (i + 1 == nums1.length) {
                j++;
            } else if (j + 1 == nums2.length) {
                i++;
            } else {
                if (nums1[i + 1] <= nums2[j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}