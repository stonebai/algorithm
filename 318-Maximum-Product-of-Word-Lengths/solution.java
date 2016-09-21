public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });
        int[] nums = new int[words.length];
        for (int i = 0;i < nums.length;i++) {
            nums[i] = encode(words[i]);
        }
        int res = 0;
        for (int i = 0;i < nums.length;i++) {
            for (int j = i + 1;j < nums.length;j++) {
                if (nums[i] & nums[j] == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
    
    private int encode(String word) {
        char[] chs = word.toCharArray();
        int res = 0;
        for (char ch : chs) {
            int shift = ch - 'a';
            res |= 1 << shift;
        }
        return res;
    }
}