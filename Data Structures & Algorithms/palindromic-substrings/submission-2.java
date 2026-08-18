// class Solution {
//     public int countSubstrings(String s) {
//         if (s.length() == 0) return 0;
//         int n = s.length();

//         boolean[][] dp = new boolean[n][n];
//         int count = 0;

//         for (int i=0;i<n;i++) {
//             dp[i][i] = true;
//             count++;
//         }

//         for (int i=0;i<n-1;i++) {
//             if (s.charAt(i) == s.charAt(i+1)) {
//                 dp[i][i+1] = true;
//                 count++;
//             }
//         }

//         // remaining diffs

//         for (int diff = 2; diff < n; diff++) {
//             for (int i=0;i<n-diff; i++) {
//                 int j = i + diff;

//                 if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
//                     dp[i][j] = true;
//                     count++;
//                 }

//             }
//         }

//         return count;
//     }
// }

class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i=0;i<s.length();i++) {
            
            count += countAroundCenter(i, i, s);

            count += countAroundCenter(i, i+1, s);
            
        }

        return count;
        
    }

    public int countAroundCenter(int start, int end, String s) {

        int count = 0;

        while(start >= 0 && end < s.length()) {

            if (s.charAt(start) != s.charAt(end)) {
                return count;
            }

            start--;
            end++;
            count++;
        }

        return count;

    }
}