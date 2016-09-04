public class Solution {
    
    private static final String LINE_SPLITER = "\n";
    private static final char INDENT = '\t';
    
    public int lengthLongestPath(String input) {
        String[] split = input.split(LINE_SPLITER);
        int i = 0, res = 0;
        while (i < split.length) {
            if (split[i].contains(".")) {
                res = Math.max(res, split[i].length());
                i++;
            } else {
                int[] nums = dfs(split, i, 1);
                res = Math.max(res, nums[0]);
                i = nums[1];
            }
        }
        return res;
    }
    
    private int[] dfs(String[] split, int index, int level) {
        int[] res = new int[2];
        int i = index + 1;
        while (i < split.length && validatePrefix(split[i], level)) {
            if (split[i].contains(".")) {
                res[0] = Math.max(res[0], split[i].length() - level);
                i++;
            } else {
                int[] nums = dfs(split, i, level + 1);
                res[0] = Math.max(res[0], nums[0]);
                i = nums[1];
            }
        }
        if (res[0] > 0) {
            res[0] += split[index].length() - level + 2;
        }
        res[1] = i;
        return res;
    }
    
    private boolean validatePrefix(String str, int num) {
        for (int i = 0;i < num;i++) {
            if (str.charAt(i) != INDENT) {
                return false;
            }
        }
        return true;
    }
}