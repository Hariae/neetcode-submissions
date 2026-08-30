class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                   // rotten++;
                } 

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        Queue<int[]> tempQ = new LinkedList<>();
        while (!q.isEmpty()) {            
            int[] curr = q.poll();
            int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                    tempQ.add(new int[] {r, c});
                    grid[r][c] = 2;
                    fresh--;
                }
            }

            if (q.isEmpty() && !tempQ.isEmpty()) {
                // one iteration done
                time++;
                q = new LinkedList<>(tempQ);
                tempQ = new LinkedList<>();
            }            
        }

        //System.out.println(rotten);

        return fresh == 0 ? time : -1;
        
    }
}
