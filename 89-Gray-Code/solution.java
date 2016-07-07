public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 0;i < n;i++) {
            List<Integer> list = new ArrayList<Integer>();
            int tmp = 1 << i;
            for (int j = res.size() - 1;j >= 0;j--) {
                list.add(res.get(j) + tmp);
            }
            res.addAll(list);
        }
        return res;
    }
}