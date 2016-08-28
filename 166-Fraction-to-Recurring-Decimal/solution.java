public class Solution {
    public String fractionToDecimal(int a, int b) {
        if (a == 0) return "0";
        StringBuilder sb = new StringBuilder();
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
        Set<Integer> set = new HashSet<Integer>();
        set.add(a);
        String str = "";
        while (a != 0) {
            a *= 10;
            str = str + a / b;
            a %= b;
            if (set.contains(a)) {
                sb.append('(');
                sb.append(str);
                sb.append(')');
                return sb.toString();
            }
        }
        sb.append(str);
        return sb.toString();
    }
}