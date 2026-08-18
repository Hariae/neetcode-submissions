class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max_1 = robDp(nums, 0, nums.length - 2);
        int max_2 = robDp(nums, 1, nums.length - 1);

        return Math.max(max_1, max_2);
    }

    public int robDp(int[] nums, int start, int end) {

        int[] dp = new int[nums.length + 2];

        for (int i=end;i>=start;i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return dp[start];
    }
}