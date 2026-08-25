class Solution {
    public int lcsUtil(String A, String B, int p1, int p2, int[][] cache) {

        if (p1 >= A.length() || p2 >= B.length()) {
            return 0;
        }

        if (cache[p1][p2] != -1) {
            return cache[p1][p2];
        }

        if (A.charAt(p1) == B.charAt(p2)) {
            cache[p1][p2] = 1 + lcsUtil(A, B, p1 + 1, p2 + 1, cache);
            //return 1 + lcsUtil(A, B, p1 + 1, p2 + 1, cache);
        } else {

            cache[p1][p2] = Math.max(lcsUtil(A, B, p1, p2 + 1, cache), lcsUtil(A, B, p1 + 1, p2, cache));
            //return cache[p1][p2];
        }

        return cache[p1][p2];

    }

    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] cache = new int[text1.length()][text2.length()];
        // for (int[] row : cache) {
        //     Arrays.fill(row, -1);
        // }
        // return lcsUtil(text1, text2, 0, 0, cache);

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i=text1.length()-1;i>=0;i--) {
            for (int j=text2.length()-1;j>=0;j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
                
            }
        }

        return dp[0][0];
    }
}
