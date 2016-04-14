public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int res = 0;
        for(int i=len-1;i>=0;i--) {
            if(citations[i]<=len - i) {
                return Math.max(citations[i], res);
            }
            else {
                res++;
            }
        }
        return res;
    }
}