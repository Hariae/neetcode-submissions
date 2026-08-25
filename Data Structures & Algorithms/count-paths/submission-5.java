class Solution {
    public int uniquePaths(int m, int n) {
        // int r = 0, c = 0;
        // int[][] cache = new int[m][n];
        // for (int i=0;i<m;i++) {
        //     Arrays.fill(cache[i], -1);
        // }
        // return uniquePathUtil(m, n, r, c, cache);

        int[][] dp = new int[m][n];

        for (int i=0;i<m;i++) {
            Arrays.fill(dp[i], 1);            
        }

        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathUtil(int m, int n, int r, int c, int[][] cache) {
        

        if (r >= m || c >=n) return 0;

        if (r == m - 1 && c == n -1) return 1;

        if (cache[r][c] != -1) return cache[r][c];

        cache[r][c] = uniquePathUtil(m, n, r+1, c, cache)+uniquePathUtil(m, n, r, c+1, cache);           
        return cache[r][c];
    }
}
