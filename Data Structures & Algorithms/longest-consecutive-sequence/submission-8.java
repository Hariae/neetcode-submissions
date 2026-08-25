class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int i=0;i<nums.length;i++) {
            int streak = 0;
            if (!set.contains(nums[i] - 1)) {
                streak++;
                int currNum = nums[i] + 1;
                while (set.contains(currNum)) {
                    streak++;
                    currNum++;
                }
                max = Math.max(max, streak);
            }
        }
        return max;
    }
}
