class Solution {

    /*
    
    r, c -> 0, 0
    1, 1
    2, 2




    
    
    */

    public boolean isValidSudoku(char[][] board) {
        int rows = 9;
        int cols = 9;

        for (int i=0;i<9;i++) {
            boolean result = performRowColValidation(board, i, i);
            if (!result) {
                return false;
            }
        }

        for (int c=0;c<9;c=c+3) {
            for (int r=0;r<9;r=r+3) {
                boolean result = performBoxValidation(board, r, c);
                if (!result) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean performBoxValidation(char[][] board, int r, int c) {
        HashSet<Character> boxSet = new HashSet<>();

        for (int row=r;row<r+3;row++) {
            for (int col=c;col<c+3;col++) {
                if (board[row][col] != '.') {
                    if (boxSet.contains(board[row][col])) {
                        return false;
                    }

                    boxSet.add(board[row][col]);
                }
            }
        }

        return true;
    }

    public boolean performRowColValidation(char[][] board, int row, int col) {
        // row
        HashSet<Character> rowSet = new HashSet<>();
        for (int c=0;c<9;c++) {
            if (board[row][c] != '.') {
                if (rowSet.contains(board[row][c])) {
                    return false;
                }

                rowSet.add(board[row][c]);
            }            
        }

        // col
        HashSet<Character> colSet = new HashSet<>();
        for (int r=0;r<9;r++) {
            if (board[r][col] != '.') {
                if (colSet.contains(board[r][col])) {
                    return false;
                }

                colSet.add(board[r][col]);
            }            
        }

        return true;

    }
}
