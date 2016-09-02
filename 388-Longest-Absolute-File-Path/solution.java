public class Solution {
    public int lengthLongestPath(String input) {
        String[] split = input.split("\n");
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
        String prefix = prefix(level);
        int i = index + 1;
        while (i < split.length && split[i].startsWith(prefix)) {
            if (split[i].contains(".")) {
                res[0] = Math.max(res[0], split[i].length() - prefix.length());
                i++;
            } else {
                int[] nums = dfs(split, i, level + 1);
                res[0] = Math.max(res[0], nums[0]);
                i = nums[1];
            }
        }
        if (res[0] > 0) {
            res[0] += split[index].length() - prefix.length() + 2;
        }
        res[1] = i;
        return res;
    }
    
    private String prefix(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < n;i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}