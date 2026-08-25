class Solution {
    /*
        [-1, 0, 1, 2, -1, -4]
          i.  j 

          -1 -> 1


    */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i=0;i<nums.length-2;i++) {
            
            int l = i + 1;
            int r = nums.length-1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }

        }

        return new ArrayList<>(result);
    }
    // public List<List<Integer>> threeSum(int[] nums) {
    //     HashSet<List<Integer>> result = new HashSet<>();

    //     HashMap<Integer, List<Integer>> map = new HashMap<>();

    //     for (int i=0;i<nums.length;i++) {
    //         List<Integer> indices = map.getOrDefault(nums[i], new ArrayList<>());
    //         indices.add(i);
    //         map.put(nums[i], indices);
    //     }
    //    // System.out.println(map);
    //     for (int i=0;i<nums.length-1;i++) {
    //         for (int j = i+1;j<nums.length;j++) {
    //             int tempSum = nums[i] + nums[j];
    //             if (map.containsKey(-1 * tempSum)) {
    //                List<Integer> indices = map.get(-1 * tempSum);

    //                for (int index : indices) {
    //                 if (index != i && index != j) {
    //                     List<Integer> tempResult = new ArrayList<>(List.of(nums[i], nums[j], nums[index]));
    //                     Collections.sort(tempResult);
    //                     result.add(tempResult);
    //                 }
    //                }                   
    //             }
    //         }
    //     }

    //     return new ArrayList<>(result);
    // }
}
