class Solution {

    /*
    - cal runningsum, reset if runnning sum < curr;
    - track max
    
    */
    public int maxSubArray(int[] nums) {
        
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            currSum += nums[i];
            currSum = Math.max(currSum, nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
