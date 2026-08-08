class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // fill init pacific and atlantic nodes

        Queue<int[]> pacificNodes = new LinkedList<>();
        Queue<int[]> atlanticNodes = new LinkedList<>();

        int rows = heights.length, cols = heights[0].length;


        for (int c=0;c<heights[0].length;c++) {
            pacificNodes.add(new int[]{0, c});
            atlanticNodes.add(new int[]{heights.length-1, c});
        }

        for (int r=0;r<heights.length;r++) {
            pacificNodes.add(new int[]{r, 0});
             atlanticNodes.add(new int[]{r, heights[0].length - 1});
        }

        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        while (!pacificNodes.isEmpty()) {
            int[] height = pacificNodes.poll();
            pacificVisited[height[0]][height[1]] = true;

            int[][] dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};

            for(int[] dir : dirs) {
                int new_r = height[0] + dir[0];
                int new_c = height[1] + dir[1];

                if (new_r < 0 || new_r >= rows || new_c < 0 || new_c >= cols) {
                    continue;
                }

                if (pacificVisited[new_r][new_c] || heights[height[0]][height[1]] >
                heights[new_r][new_c]) {
                    continue;
                }

                pacificNodes.add(new int[]{new_r, new_c});
            }
        }

        while (!atlanticNodes.isEmpty()) {
            int[] height = atlanticNodes.poll();
            atlanticVisited[height[0]][height[1]] = true;

            int[][] dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};

            for(int[] dir : dirs) {
                int new_r = height[0] + dir[0];
                int new_c = height[1] + dir[1];

                if (new_r < 0 || new_r >= rows || new_c < 0 || new_c >= cols) {
                    continue;
                }

                if (atlanticVisited[new_r][new_c] || heights[height[0]][height[1]] >
                heights[new_r][new_c]) {
                    continue;
                }

                atlanticNodes.add(new int[]{new_r, new_c});
            }
        }

        // System.out.println(Arrays.deepToString(pacificVisited));
        // System.out.println(Arrays.deepToString(atlanticVisited));

        List<List<Integer>> result = new ArrayList<>();


        for (int r=0; r<rows; r++) {
            for (int c=0;c<cols;c++) {
                if (pacificVisited[r][c] && atlanticVisited[r][c]) {
                    List<Integer> res = List.of(r, c);
                    result.add(res);
                }
            }
        }
        
        return result;
        
    }
}
