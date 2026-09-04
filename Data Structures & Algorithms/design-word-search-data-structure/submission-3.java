class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean word;

    TrieNode() {
        this.children = new HashMap<>();
        this.word = false;
    }
}


class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            TrieNode node = curr.children.getOrDefault(c, new TrieNode());
            curr.children.put(c, node);
            curr = node;
        }

        curr.word = true;
    }

    public boolean search(String word, TrieNode node) {
        TrieNode curr = node;

        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {

                if (c == '.') {

                    for (Character keyChar : curr.children.keySet()) {
                        if (search(word.substring(i+1), curr.children.get(keyChar))) {
                            return true;
                        }
                    }

                    return false;

                } else {
                    return false;
                }

            } else {
                curr = curr.children.get(c);
            }
        }

        return curr.word;
    }
    
    public boolean search(String word) {
       return search(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */