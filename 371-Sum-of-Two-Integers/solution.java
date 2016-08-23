public class Solution {
    public int getSum(int a, int b) {
        while ((a & b) != 0) {
            int c = a ^ b;
            int d = (a & b) << 1;
            a = c;
            b = d;
        }
        return a | b;
    }
}