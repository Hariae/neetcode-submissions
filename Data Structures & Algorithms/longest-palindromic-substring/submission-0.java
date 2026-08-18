class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] result = new int[2];
        if (s.length() == 0) return "";

        // all 1 char substrings are palindromes
        for (int i=0;i<n;i++) {
            dp[i][i] = true;

        }

        // result[0] = 0;
        // result[1] = 0;

        for (int i=0;i<n-1;i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;    
                result[0] = i;
                result[1] = i + 1;
            }            
        }

        // fill dp array

        for (int diff = 2; diff < n; diff++) {
            for (int i=0; i < n-diff; i++ ) {
                int j = i + diff;

                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
                    dp[i][j] = true;
                    result[0] = i;
                    result[1] = j;

                }
            }
        }

        return s.substring(result[0], result[1] + 1);
        
    }
}