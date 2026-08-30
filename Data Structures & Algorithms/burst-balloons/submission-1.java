class Solution {

    /*
    
        coins = nums[i-1] * nums[i] * nums[i+1]


        1, 4, 2
        4, 2, 3
        2,3,7 -> 42
        3,7,1

        [4, 2, 7]

        1,4,2
        4,2,7 -> 56
        2,7,1

        4, 7

        -> 28

        -> 7




            4 2 5 7
        4.  
        2
        3
        7           

    */

    // public int maxCoins(int[] nums) {

    //     List<Integer> curr = new ArrayList<>();
    //     for (int num : nums) {
    //         curr.add(num);
    //     }
       
    //    return maxCoinsUtil(nums, curr, 0);
      
    // }

    // public int maxCoinsUtil(List<Integer> curr, int coins) {

    //     if (curr.size() == 0) {
    //         return coins;
    //     }

    //     int max = 0;    
    //     for (int i=0;i<curr.size();i++) {
    //         int prev = (i==0) ? 1 : curr.get(i-1);
    //         int next = (i == curr.size()-1) ? 1 : curr.get(i+1);
    //         int c = curr.get(i);

    //         curr.remove(i);
    //         int result = maxCoinsUtil(nums, curr, coins + (prev * c * next));         
    //         max = Math.max(max, result);
    //         curr.add(i, c);

    //     }

    //     return max;



    // }

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1; newNums[newNums.length - 1] = 1;

        for (int i=0;i<nums.length;i++) {
            newNums[i+1] = nums[i];
        }

        int[][] memo = new int[n][n];



        return maxCoinsUtil(newNums, 1, newNums.length-2, memo);
        
    }

    public int maxCoinsUtil(int[] nums, int left, int right, int[][] memo) {

        if (left > right) {
            return 0;
        }

        if (memo[left][right] != 0) return memo[left][right];
        
        int max = -1;
        for (int i=left;i<=right;i++) {
            int curr_coins = nums[left - 1] * nums[i] * nums[right + 1];
            int result = maxCoinsUtil(nums, left, i -1, memo) + curr_coins + maxCoinsUtil(nums, i+1, right, memo);
            max = Math.max(result, max);
        }
        
        memo[left][right] = max;
        return max;

    }
}
