class Solution {
    /*
        [-1, 0, 1, 2, -1, -4]
          i.  j 

          -1 -> 1


    */

    // public List<List<Integer>> threeSum(int[] nums) {
    //     Arrays.sort(nums);
    //     HashSet<List<Integer>> result = new HashSet<>();

    //     for (int i=0;i<nums.length-2;i++) {
            
    //         int l = i + 1;
    //         int r = nums.length-1;

    //         while (l < r) {
    //             int sum = nums[i] + nums[l] + nums[r];
    //             if (sum == 0) {
    //                 result.add(List.of(nums[i], nums[l], nums[r]));
    //                 l++;
    //                 r--;
    //             } else if (sum > 0) {
    //                 r--;
    //             } else {
    //                 l++;
    //             }
    //         }

    //     }

    //     return new ArrayList<>(result);
    // }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        HashSet<Integer> dups = new HashSet<Integer>();

        for (int i=0;i<nums.length;i++) {
            if (dups.contains(nums[i])) continue;
            dups.add(nums[i]);

            HashSet<Integer> seen = new HashSet<Integer>();
            for (int j=i+1;j<nums.length;j++) {
                int complement = -1 * (nums[i] + nums[j]);
                if (seen.contains(complement)) {
                    List<Integer> tempResult = new ArrayList<>(List.of(
                        nums[i], nums[j], complement
                    ));
                    Collections.sort(tempResult);
                    res.add(tempResult);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(res);
    }
}
