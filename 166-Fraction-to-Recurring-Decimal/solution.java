public class Solution {
    public String fractionToDecimal(int x, int y) {
        if (x == 0) return "0";
        StringBuilder sb = new StringBuilder();
        long a = x;
        long b = y;
        if (a > 0) {
            if (b < 0) {
                b = -b;
                sb.append('-');
            }
        } else {
            a = -a;
            if (b < 0) {
                b = -b;
            } else {
                sb.append('-');
            }
        }
        sb.append(a / b);
        a = a % b;
        if (a == 0) {
            return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(a, 0);
        List<Long> list = new ArrayList<Long>();
        while (a != 0) {
            a *= 10;
            list.add(a / b);
            a %= b;
            if (map.containsKey(a)) {
                int index = map.get(a);
                int i = 0;
                while (i < index) {
                    sb.append(list.get(i++));
                }
                sb.append('(');
                while (i < list.size()) {
                    sb.append(list.get(i++));
                }
                sb.append(')');
                return sb.toString();
            } else {
                map.put(a, list.size());
            }
        }
        for (int i = 0;i < list.size();i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}