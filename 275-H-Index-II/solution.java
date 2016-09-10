public class Solution {
    public int hIndex(int[] citations) {
        int i = 0, j = citations.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int len = citations.length - mid;
            int val = citations[mid];
            if (val > len) {
                j = mid;
            } else if (val < len) {
                i = mid + 1;
            } else {
                return val;
            }
        }
        return Math.min(citations[i], citations.length - i);
    }
}