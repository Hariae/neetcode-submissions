class Solution {
    public int maxProfit(int[] prices) {
        int buyMin = prices[0];
        int maxProfit = 0;
        int i=1;
        while(i < prices.length) {
            maxProfit = Math.max(maxProfit, prices[i] - buyMin);
            buyMin = Math.min(buyMin, prices[i]);
            i++;

           // System.out.println(maxProfit + "")
        } 

        return maxProfit;
        
    }
}
