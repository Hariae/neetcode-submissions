class Solution {
    public int rob(int[] nums) {  
        // int[] cache = new int[nums.length + 2];
        // Arrays.fill(cache, -1);
        
        // return robUtil(nums, 0, cache);

        int[] dp = new int[nums.length + 2];

        for (int i=nums.length-1;i>=0;i--) {            
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
            //System.out.println(dp[i]);
        }

        return dp[0];

                                                                                                                                         
    }

    public int robUtil(int[] nums, int index, int[] cache) {
        
        if (index >= nums.length) return 0;

        if (cache[index] > -1) {
            return cache[index];
        }


        cache[index] = Math.max(
            robUtil(nums, index + 1, cache), 
            robUtil(nums, index + 2, cache) + nums[index]);
        
        return cache[index];
       

    }
}
