class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
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
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode curr) {
       // if (curr == null) return false;
        char c = word.charAt(index);

        // base condition
        if (index == word.length() - 1) {
            
            if (c == '.') {
                for (TrieNode child : curr.children.values()) {
                    if (child.endOfWord) {
                        return true;
                    }
                }
                return false;
            }
            else {
                return curr.children.containsKey(c) && curr.children.get(c).endOfWord;
            }
        }
       

        

        if (c == '.') {

            for (TrieNode child : curr.children.values()) {
                if (dfs(word, index+1, child)) {
                    return true;
                }
            }

        } else {
            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
            if (dfs(word, index+1, curr)) {
                return true;
            }
        }


        return false;
    }
}
