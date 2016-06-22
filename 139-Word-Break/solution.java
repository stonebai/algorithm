public class Solution {
    
    Map<String, Boolean> visited = new HashMap<String, Boolean>();
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.equals("") || wordDict.contains(s)) {
            return true;
        }
        if (visited.containsKey(s)) {
            return visited.get(s);
        }
        
        for (int i = 1;i < s.length();i++) {
            String str = s.substring(0, i);
            if (wordDict.contains(str) && wordBreak(s.substring(i))) {
                visited.put(s, true);
                return true;
            }
        }
        
        visited.put(s, false);
        return false;
    }
}