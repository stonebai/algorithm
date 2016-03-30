public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        char[] chs = s.toCharArray();
        Set<Character> set = canPalindrome(chs);
        if(set.size()>1) return res;
        else if(set.size()==0) {
            List<Character> list = new ArrayList<Character>();
            Set<Character> tSet = new HashSet<Character>();
            for(char c : chs) {
                if(tSet.contains(c)) {
                    tSet.remove(c);
                }
                else {
                    tSet.add(c);
                    list.add(c);
                }
            }
            List<String> strs = permute(list);
            for(String str : strs) {
                res.add(str + new StringBuilder(str).reverse().toString());
            }
        }
        else {
            char mid = set.iterator().next();
            boolean one = true;
            List<Character> list = new ArrayList<Character>();
            Set<Character> tSet = new HashSet<Character>();
            for(char c : chs) {
                if(c==mid && one) {
                    one = false;
                }
                else {
                    if(tSet.contains(c)) {
                        tSet.remove(c);
                    }
                    else {
                        tSet.add(c);
                        list.add(c);
                    }
                }
            }
            List<String> strs = permute(list);
            for(String str : strs) {
                res.add(str + mid + new StringBuilder(str).reverse().toString());
            }
        }
        return res;
    }
    
    private List<List<Character>> permute(List<Character> input, int start) {
        List<List<Character>> res = new ArrayList<List<Character>>();
        Character ch = input.get(start);
        if(start==input.size()-1) {
            List<Character> tmp = new ArrayList<Character>();
            tmp.add(ch);
            res.add(tmp);
        }
        else {
            List<List<Character>> lists = permute(input, start+1);
            for(List<Character> list : lists) {
                for(int i=0;i<list.size();i++) {
                    List<Character> tmp = new ArrayList<Character>(list);
                    tmp.add(i, ch);
                    res.add(tmp);
                    if(i<list.size()-1 && list.get(i)==list.get(i+1)) {
                        while(i<list.size()-1 && list.get(i)==list.get(i+1))i++;
                        i++;
                    }
                }
                if(ch!=list.get(list.size()-1)) {
                    List<Character> tmp = new ArrayList<Character>(list);
                    tmp.add(ch);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    
    private List<String> permute(List<Character> list) {
        List<String> res = new ArrayList<String>();
        if(list.size()==0) {
            res.add("");
            return res;
        }
        List<List<Character>> tmps = permute(list, 0);
        for(List<Character> tmp : tmps) {
            StringBuilder sb = new StringBuilder();
            for(Character c : tmp) {
                sb.append(c);
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    private Set<Character> canPalindrome(char[] chs) {
        Set<Character> set = new HashSet<Character>();
        for(char c : chs) {
            if(set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set;
    }
    
}