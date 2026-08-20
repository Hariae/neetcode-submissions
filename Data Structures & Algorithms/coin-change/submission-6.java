class Solution {


    /*
    
        0 1 2 3 4 5 6 7 8 9 10 11
      1.  1                    11
      5.  
      10  
    
    */
    // public int coinChange(int[] coins, int amount) {
    //     Arrays.sort(coins);
    //     int[] cache = new int[amount + 1];
    //     Arrays.fill(cache, -1);
    //     cache[0] = 0;
    //     return coinChangeUtil(coins, amount, cache);
    //    // return result;



        
    // }

      public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i=1;i<=amount;i++) {
            for (int j=0;j<coins.length;j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
                
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
      }

    

    public int coinChangeUtil(int[] coins, int amount, int[] cache) {

        if (amount < 0) return -1;

       

        if (amount == 0) {
            //result = Math.min(count, result);
            return 0;
        }
        
        // int result = 1;
        // int tempAmount = amount;

        if (cache[amount] != -1) return cache[amount];
        
        int minCount = Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++) {
        
            int result = coinChangeUtil(coins, amount - coins[i], cache);
            if (result > -1) {
                minCount = Math.min(minCount, result + 1);
            }
        }


        cache[amount] = minCount != Integer.MAX_VALUE ? minCount : -1;
        

        return cache[amount];

    }
}
