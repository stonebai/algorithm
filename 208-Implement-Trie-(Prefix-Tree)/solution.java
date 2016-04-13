class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] next;
    public boolean isWord;
    
    public TrieNode() {
        next = new TrieNode[26];
        isWord = false;
    }
}

public class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for(char ch : chs) {
            int index = ch - 'a';
            if(cur.next[index]==null) {
                cur.next[index] = new TrieNode();
            }
            cur = cur.next[index];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for(char ch : chs) {
            int index = ch - 'a';
            cur = cur.next[index];
            if(cur==null) return false;
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] chs = prefix.toCharArray();
        TrieNode cur = root;
        for(char ch : chs) {
            int index = ch - 'a';
            cur = cur.next[index];
            if(cur==null) return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");