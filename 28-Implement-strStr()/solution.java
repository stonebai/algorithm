public class Solution {
    /**
     * Brute force way
     **/
    public int strStr(String haystack, String needle) {
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        for(int i=0;i<=text.length-pattern.length;i++) {
            int j=0;
            for(;j<pattern.length;j++) {
                if(text[i+j]!=pattern[j]) break;
            }
            if(j==pattern.length) return i;
        }
        return -1;
    }
}