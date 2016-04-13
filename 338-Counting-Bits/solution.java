public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0;i<=num;i++) {
            res[i] = bits(i);
        }
        return res;
    }
    
    private int bits(int num) {
        int count = 0;
        do {
            count += num & 1;
            num /= 2;
        } while(num>0);
        return count;
    }
}