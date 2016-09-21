public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        for (int num : nums) {
            if (num == lower) {
                lower++;
            } else {
                int bound = num - 1;
                if (lower == bound) {
                    res.add(String.valueOf(lower);
                } else {
                    res.add(lower + "->" + bound);
                }
                lower = bound + 1;
            }
        }
        return res;
    }
}