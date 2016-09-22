public class Solution {
    
    private static int[] hours = {1, 2, 4, 8};
    private static int[] minutes = {1, 2, 4, 8, 16, 32};
    
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for (int i = 0;i <= num;i++) {
            List<String> l1 = hour(i);
            List<String> l2 = minute(num - i);
            for (String s1 : l1) {
                for (String s2 : l2) {
                    res.add(s1 + ":" + s2);
                }
            }
        }
        return res;
    }
    
    private List<String> minute(int num) {
        List<String> res = new ArrayList<String>();
        if (num < 0 || num > 5) {
            return res;
        }
        List<Integer> list = calculate(minutes, 0, num, 60);
        for (int val : list) {
            if (val > 9) {
                res.add(String.valueOf(val));
            } else {
                res.add("0" + val);
            }
        }
        return res;
    }
    
    private List<String> hour(int num) {
        List<String> res = new ArrayList<String>();
        if (num < 0 || num > 3) {
            return res;
        }
        List<Integer> list = calculate(hours, 0, num, 12);
        for (int val : list) {
            res.add(String.valueOf(val));
        }
        return res;
    }
    
    private List<Integer> calculate(int[] num, int pos, int n, int upper) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        if (num.length - pos < n) {
            return res;
        }
        for (int i = pos;i < num.length;i++) {
            List<Integer> list = calculate(num, i + 1, n - 1, upper);
            for (int v : list) {
                int val = v + num[i];
                if (val < upper) {
                    res.add(val);
                }
            }
        }
        return res;
    }
}