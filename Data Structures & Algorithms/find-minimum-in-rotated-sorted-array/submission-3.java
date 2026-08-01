class Solution {
    public int findMin(int[] nums) {

        int left = 0, right = nums.length-1;

        while(left < right) {
            int mid = (left + right) / 2;

          
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            } 
        }

        // 4, 5, 6, 7
        // 0  1   2. 3
        // mid -> 1
        // 5

        return nums[left];
        
    }
}
