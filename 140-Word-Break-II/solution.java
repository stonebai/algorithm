public class Solution {
    
    private Map<String, List<String>> map = new HashMap<String, List<String>>();
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<String>();
        // for(int j = s.length() - 1; j >= 0; j--){
        //     if(wordDict.contains(s.substring(j)))
        //         break;
        //     else{
        //         if(j == 0)
        //             return res;
        //     }
        // }
        for(int i=1;i<=s.length();i++) {
            String t = s.substring(0, i);
            if(wordDict.contains(t)) {
                List<String> list = wordBreak(s.substring(i), wordDict);
                for(String str : list) {
                    res.add(t + " " + str);
                }
            }
        }
        if(wordDict.contains(s)) res.add(s);
        map.put(s, res);
        return res;
    }
}