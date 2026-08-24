class Solution {
    public int uniquePaths(int m, int n) {
        int r = 0, c = 0;
        int[][] cache = new int[m][n];
        for (int i=0;i<m;i++) {
            Arrays.fill(cache[i], -1);
        }
        return uniquePathUtil(m, n, r, c, cache);
    }

    public int uniquePathUtil(int m, int n, int r, int c, int[][] cache) {
        

        if (r >= m || c >=n) return 0;

        if (r == m - 1 && c == n -1) return 1;

        if (cache[r][c] != -1) return cache[r][c];

        cache[r][c] = uniquePathUtil(m, n, r+1, c, cache)+uniquePathUtil(m, n, r, c+1, cache);           
        return cache[r][c];
    }
}
