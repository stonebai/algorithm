public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            int num = a.charAt(i) - '0' + b.charAt(j) + c;
            c = num / 2;
            num = num % 2;
            sb.insert(0, num);
        }
        while (i >= 0) {
            int num = a.charAt(i) + c;
            c = num / 2;
            num = num % 2;
            sb.insert(0, num);
        }
        while (j >= 0) {
            int num = b.charAt(j) + c;
            c = num / 2;
            num = num % 2;
            sb.insert(0, num);
        }
        if (c == 1) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
}