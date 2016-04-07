public class WordDictionary {
    class Trie{
        public Trie[] next = new Trie[26];
        public boolean isWord;
    }
    
    Trie root = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        Trie tmp = root;
        char[] chs = word.toCharArray();
        for(int i=0;i<chs.length;i++) {
            int offset = chs[i] - 'a';
            if(tmp.next[offset]==null) {
                tmp.next[offset] = new Trie();
            }
            tmp = tmp.next[offset];
        }
        tmp.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        Queue<Trie> q = new LinkedList<>();
        q.offer(root);
        int point = 0;
        while(!q.isEmpty() && point<chs.length) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Trie tmp = q.poll();
                if(chs[point]=='.') {
                    for(Trie n : tmp.next) {
                        if(n!=null) q.offer(n);
                    }
                }
                else {
                    int offset = chs[point] - 'a';
                    if(tmp.next[offset]!=null) q.offer(tmp.next[offset]);
                }
            }
            point++;
        }
        while(!q.isEmpty()) {
            Trie trie = q.poll();
            if(trie.isWord) return true;
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");