class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean word;

    TrieNode() {
        this.children = new HashMap<>();
        this.word = false;
    }
}

class Solution {
    TrieNode root;
    Set<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();

        // populate words in trie
        for (String word : words) {
            insert(word);
        }

        // try dfs and search for each word
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, "", i, j, visited, root);
            }
        }

        return new ArrayList<>(result);        

    }

   

    public void dfs(char[][] board, String currWord, int i, int j, boolean[][] visited, TrieNode curr) {
        // base
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        currWord += board[i][j];
        visited[i][j] = true;

        // if (currWord.charAt(0) == 'b') {
            // System.out.println(currWord);
        // }
        
        boolean found = search(currWord);
        if (found) {
            result.add(currWord);
        }

        // if (currWord.charAt(0) == 'b') {
        //     System.out.println(currWord + " " + curr.children.containsKey(board[i][j]));
        // }
        if (!curr.children.containsKey(board[i][j])) {
            visited[i][j] = false;
            return;
        }

        TrieNode child = curr.children.get(board[i][j]);

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            // if (currWord.equals("backen")) {
            //     System.out.println(new_i + " " + new_j);
            // }
            dfs(board, currWord, new_i, new_j, visited, child);
        }

        currWord = currWord.substring(0, currWord.length()-1);
        visited[i][j] = false;
        return;

    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }

        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }

        return curr.word;
    }

    public boolean startsWith(TrieNode curr, String word) {        

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }

        return true;
    }
}
