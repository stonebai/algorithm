public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            } else {
                int leftLen = 0;
                if (map.containsKey(num - 1)) {
                    leftLen = map.get(num - 1);
                }
                int rightLen = 0;
                if (map.containsKey(num + 1)) {
                    rightLen = map.get(num + 1);
                }
                int leftIndex = num - leftLen;
                int rightIndex = num + rightLen;
                int totalLen = leftLen + rightLen + 1;
                map.put(leftIndex, totalLen);
                map.put(rightIndex, totalLen);
                map.put(num, totalLen);
                len = Math.max(len, totalLen);
            }
        }
        return len;
    }
}