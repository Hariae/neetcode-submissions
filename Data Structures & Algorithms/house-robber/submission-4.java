class Solution {
    public int rob(int[] nums) {  
        int[] cache = new int[nums.length + 2];
        Arrays.fill(cache, -1);
        
        return robUtil(nums, 0, cache);
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
