class Solution {
    public int[] productExceptSelf(int[] nums) {
        int rp = 1;
        int[] result = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            result[i] = rp;
            rp = rp * nums[i];
        }

        rp=1;

        for(int i=nums.length-1;i>=0;i--) {
            result[i] = result[i] * rp;
            rp = rp * nums[i];
        }

        return result;
    }
}  
