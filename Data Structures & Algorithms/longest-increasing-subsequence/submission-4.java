// class Solution {
//     public int lengthOfLIS(int[] nums) {

//         int[] dp = new int[nums.length];

//         Arrays.fill(dp, 1);


//         for (int i=0;i<nums.length;i++) {
//             for (int j = 0;j<i;j++) {
//                 if (nums[j] < nums[i]) {
//                     dp[i] = Math.max(dp[j] + 1, dp[i]);
//                 }                
//             }
//         }

//         int res = -1;
//         for (int i=0;i<dp.length;i++) {
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }


class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> sub = new ArrayList<>();

        sub.add(nums[0]);

        for (int i=1;i<nums.length;i++) {
            if (sub.get(sub.size() - 1) < nums[i]) {
                sub.add(nums[i]);
            } else {

                int j = binarySearch(sub, nums[i]);

                // while(nums[i] > sub.get(j)) {
                //     j++;
                // }

                sub.set(j, nums[i]);

            }
        }

        return sub.size();
        
    }


    public int binarySearch(List<Integer> sub, int num) {

        int left = 0;
        int right = sub.size() -1 ;

        while(left < right) {
            int mid = (left + right)/2;

            if (sub.get(mid) == num) {
                return mid;
            } else if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;

    }
}
