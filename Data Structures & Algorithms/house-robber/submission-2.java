class Solution {
    public int rob(int[] nums) {  
        int[] cache = new int[nums.length + 2];
        Arrays.fill(cache, -1);
        // for (int i=0;i<cache.length;i++)
        //     System.out.print(cache[i] + " - ");
        return robUtil(nums, 0, cache);
    }

    public int robUtil(int[] nums, int index, int[] cache) {
        
        if (index >= nums.length) return 0;

        if (cache[index] != -1) {
            return cache[index];
        }


        cache[index] = Math.max(
            robUtil(nums, index + 1, cache), 
            robUtil(nums, index + 2, cache) + nums[index]);


        // System.out.println(cache[index] + " " + + index + " " + loot +  " " + Math.max(robUtil(nums, index + 1, loot, cache), robUtil(nums, index + 2, loot + nums[index], cache)));
        return cache[index];
       // return Math.max(robUtil(nums, index + 1, loot, cache), robUtil(nums, index + 2, loot + nums[index], cache));

    }
}
