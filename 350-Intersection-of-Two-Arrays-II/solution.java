public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num1 : nums1) {
            if (map.containsKey(num1)) {
                map.put(num1, map.get(num1) + 1);
            } else {
                map.put(num1, 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num2 : nums2) {
            if (map.containsKey(num2)) {
                int count = map.get(num2);
                if (count > 0) {
                    list.add(num2);
                    map.put(num2, count - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}