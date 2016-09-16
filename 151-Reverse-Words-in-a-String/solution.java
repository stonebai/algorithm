public class Solution {
    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1;i >= 0;i++) {
            if (split[i].equals("")) {
                continue;
            }
            sb.append(split[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}