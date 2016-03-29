public class Solution {
    /**
     * Brute force way
     **/
    // public int strStr(String haystack, String needle) {
    //     char[] text = haystack.toCharArray();
    //     char[] pattern = needle.toCharArray();
    //     for(int i=0;i<=text.length-pattern.length;i++) {
    //         int j=0;
    //         for(;j<pattern.length;j++) {
    //             if(text[i+j]!=pattern[j]) break;
    //         }
    //         if(j==pattern.length) return i;
    //     }
    //     return -1;
    // }
    public int strStr(String a, String b) {
        if(b.length()==0) return 0;
        char[] text = a.toCharArray();
        char[] pattern = b.toCharArray();
        int[] bad = process(pattern);
        int i = 0;
        int j = pattern.length - 1;
        while(i<=text.length-pattern.length) {
            if(text[i+j]==pattern[j]) {
                j--;
            }
            else {
                i += Math.max(1, j - bad[text[i+j]]);
                j = pattern.length - 1;
            }
            if(j==-1) return i;
        }
        return -1;
    }
    
    private int[] process(char[] pattern) {
        int[] bad = new int[256];
        for(int i=0;i<256;i++) {
            bad[i] = -1;
        }
        for(int i=0;i<pattern.length;i++) {
            bad[pattern[i]] = i;
        }
        return bad;
    }
}