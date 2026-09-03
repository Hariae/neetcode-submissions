class Solution {
    public void solve(char[][] board) {
        // border traversal

        int rows = board.length, cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();


        for (int r = 0;r<rows;r++) {
            if (board[r][0] == 'O') {
                q.add(new int[] {r, 0});
            }

            if (board[r][cols-1] == 'O') {
                q.add(new int[] {r, cols-1});
            }
        }

        for (int c = 0;c<cols;c++) {
            if (board[0][c] == 'O') {
                q.add(new int[] {0, c});
            }

            if (board[rows-1][c] == 'O') {
                q.add(new int[] {rows-1, c});
            }
        }

        // do bfs and mark them as # for safe

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            board[r][c] = '#';

            int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];          
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && board[newR][newC] == 'O') {
                    q.add(new int[]{newR, newC});
                }
            }
        }


        // mark remaining Os as X and #s as Os

        for (int r=0;r<rows;r++) {
            for (int c = 0;c<cols;c++) {
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } 
            }
        }
    }
}