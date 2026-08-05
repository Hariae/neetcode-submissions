class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] == word.charAt(0)) {
                    backtrack(board, word, 0, i, j);
                }
                
            }
        }
        
        return result;
    }

    boolean result = false;

    public void backtrack(char[][] board, String word, int index, int r, int c) {

        // base
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || result) {
            return;
        }

      // System.out.println(board[r][c] + " " + r + " " + c + " " + index);

        if (index == word.length()) {
            result = true;
            return;
        }

        

        if (board[r][c] == word.charAt(index)) {

            if (index == word.length()-1) {
                result = true;
                return;
            }

            // explore next char
            char curr = board[r][c];
            
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : dirs) {
                int new_r = r + dir[0];
                int new_c = c + dir[1];
                board[r][c] = '#';
                backtrack(board, word, index + 1, new_r, new_c);
                board[r][c] = curr;
                if (result) {
                    return;
                }
            }
        } 
        
       //board[i][j] = c;
        return;
        
    }
}
