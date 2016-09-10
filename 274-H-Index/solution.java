public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int pre = 0;
        for (int i = 0;i < citations.length;i++) {
            int len = citations.length - i;
            int cur = citations[i];
            if (len >= cur) {
                pre = cur;
            } else {
                pre = Math.max(pre, len);
                break;
            }
        }
        return pre;
    }
}