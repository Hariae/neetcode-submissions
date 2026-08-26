class Solution {
    public int trap(int[] height) {
       int l = 0, r = height.length-1;
        int totalWater = 0;
        int left_max = 0, right_max = 0;
        while (l < r) {

            if (height[l] < height[r]) {
                left_max = Math.max(left_max, height[l]);
                totalWater += left_max - height[l];
                l++;
            } else {
                right_max = Math.max(right_max, height[r]);
                totalWater += right_max - height[r];
                r--;
            }
        }

        return totalWater;
    }
}
