class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {
            int streak = 0;
            if (!set.contains(num - 1)) {
                streak++;
                int currNum = num + 1;
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
