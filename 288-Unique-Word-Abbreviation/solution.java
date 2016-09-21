public class ValidWordAbbr {
    
    private Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        this.map = new HashMap<String, Set<String>>();
        for (String word : dictionary) {
            String str = abbreviate(word);
            if (this.map.containsKey(str)) {
                this.map.get(str).add(word);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(word);
                this.map.put(str, set);
            }
        }
    }

    public boolean isUnique(String word) {
        String str = abbreviate(word);
        if (this.map.containsKey(str)) {
            Set<String> set = this.map.get(str);
            if (set.size() == 1) {
                if (set.iterator().next().equals(word)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
    
    private String abbreviate(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");