public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length-1;i++) {
            if(chs[i]=='+' && chs[i+1]=='+') {
                chs[i] = '-';
                chs[i+1] = '-';
                res.add(new String(chs));
                chs[i] = '+';
                chs[i+1] = '+';
            }
        }
        return res;
    }
}