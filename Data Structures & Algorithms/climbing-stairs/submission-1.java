class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 3];    
        for (int i=0;i<cache.length;i++) {
            cache[i] = -1;
        }
        return climbStairsUtil(n, 0, cache);
    }

    

    public int climbStairsUtil(int n, int curr, int[] cache) {
        if (curr == n) return 1;

        if (curr > n) return 0;

        cache[curr + 1] = cache[curr + 1] != -1 ? cache[curr + 1] : climbStairsUtil(n , curr + 1, cache);
        cache[curr + 2] = cache[curr + 2] != -1  ? cache[curr + 2] : climbStairsUtil(n , curr + 2, cache);
        
        
        

        return cache[curr + 1] + cache[curr + 2];
    }
}
