class Trie {
    
    class TrieNode{
        public Map<Character, TrieNode> children;
        public boolean isWord;
        
        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            isWord = false;
        }
    }
    
    public TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children.containsKey(ch)){
                curr = curr.children.get(ch);
            }
            else{
                curr.children.put(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;    
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */