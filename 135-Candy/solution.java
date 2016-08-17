public class Solution {
    public int candy(int[] ratings) {
        int res = 0;
        int i = 0;
        while (i < ratings.length) {
            int a = i + 1;
            while (a < ratings.length && ratings[a] > ratings[a - 1]) a++;
            int b = a--;
            while (b < ratings.length && ratings[b] < ratings[b - 1]) b++;
            if (--b - a > a - i) {
                int level = 2;
                for (int j = b - 1;j >= a;j--) {
                    res += level++;
                }
                level = 1;
                for (int j = i;j < a;j++) {
                    res += level++;
                }
            } else {
                int level = 1;
                for (int j = i;j <= a;j++) {
                    res += level++;
                }
                level = 2;
                for (int j = b - 1;j > a;j--) {
                    res += level++;
                }
            }
            if (b == ratings.length - 1) {
                if (a == b) return res;
                else return res + 1;
            } else {
                i = b;
            }
        }
        return res;
    }
}