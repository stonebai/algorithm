public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int key = map.get(num);
                if (key == 2) {
                    map.remove(num);
                } else {
                    map.put(num, key + 1);
                }
            } else {
                map.put(num, 1);
            }
        }
        return map.keySet().iterator().next();
    }
}