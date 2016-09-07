public class Solution {
    // public int numDecodings(String s) {
    //     if(s==null)return 0;
    //     return solve(s, 0);
    // }
    // public int solve(String s, int pos){
    //     int length = s.length();
    //     if(pos>=length-1)return 1;
    //     if(s.charAt(pos)=='1'){
    //         return solve(s,pos+1)+solve(s,pos+2);
    //     }
    //     else if(s.charAt(pos)=='2'&&s.charAt(pos+1)<='6'){
    //         return solve(s,pos+1)+solve(s,pos+2);
    //     }
    //     else return solve(s,pos+1);
    // }
    public int numDecodings(String s) {
        if(s==null || s.length()<1 || s.charAt(0)=='0')return 0;
        int pA = 1;
        int pB = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){
                    pB = pA;
                    pA = 0;
                }
                else{
                    return 0;
                }
            }
            else{
                if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)>='1' && s.charAt(i)<='6')){
                    int tmp = pA + pB;
                    pB = pA;
                    pA = tmp;
                }
                else{
                    pA = pA + pB;
                    pB = 0;
                }
            }
        }
        return pA + pB;
    }
    // public int numDecodings(String s){
    //     if(s==null || s.length()==0)return 1;
    //     if(s.charAt(0)=='1' && s.length()>1)return numDecodings(s.substring(1))+numDecodings(s.substring(2));
    //     else if(s.charAt(0)=='2'&& s.length()>1 && s.charAt(1)<='6')return numDecodings(s.substring(1))+numDecodings(s.substring(2));
    //     else return numDecodings(s.substring(1));
    // }
}