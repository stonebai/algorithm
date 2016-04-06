public class Solution {
    public String minWindow(String s, String t) {
        if(t==null || s==null || t.length()==0 || s.length()==0) return "";
        char[] tchs = t.toCharArray();
        char[] schs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c : tchs) {
            count++;
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        int start = 0;
        int end = 0;
        String res = null;
        for(;end<schs.length;end++) {
            if(map.containsKey(schs[end])) {
                if(map.get(schs[end])>0) {
                    count--;
                }
                map.put(schs[end], map.get(schs[end])-1);
            }
            if(count==0) {
                while(!map.containsKey(schs[start]) || map.get(schs[start])<0) {
                    if(map.containsKey(schs[start])) {
                        map.put(schs[start], map.get(schs[start])+1);
                    }
                    start++;
                }
                int len = end - start + 1;
                if(res==null || len<res.length()) {
                    res = s.substring(start, end+1);
                }
                map.put(schs[start], map.get(schs[start])+1);
                count++;
                start++;
            }
        }
        return res==null?"":res;
    }
}