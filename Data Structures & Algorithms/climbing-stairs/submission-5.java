class Solution {
    public int climbStairs(int n) {
        // int[] cache = new int[n + 2];    
        // for (int i=0;i<cache.length;i++) {
        //     cache[i] = -1;
        // }
        // return climbStairsUtil(n, 0, cache);

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        if (n >= 2) {
            dp[2] = 2;            
        }

        for (int i=3;i<=n;i++) {
            
            dp[i] = dp[i-1] + dp[i-2];
             
            
        }

        return dp[n];
        
    }

    

    public int climbStairsUtil(int n, int curr, int[] cache) {
        if (curr == n) return 1;

        if (curr > n) return 0;

        cache[curr + 1] = cache[curr + 1] != -1 ? cache[curr + 1] : climbStairsUtil(n , curr + 1, cache);
        cache[curr + 2] = cache[curr + 2] != -1  ? cache[curr + 2] : climbStairsUtil(n , curr + 2, cache);
        
        cache[curr] = cache[curr + 1] + cache[curr + 2];
        

        return cache[curr];
    }
}
 