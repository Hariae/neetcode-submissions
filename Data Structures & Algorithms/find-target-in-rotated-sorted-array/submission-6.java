class Solution {
    public int search(int[] nums, int target) {

        int pivotIndex = findPivot(nums);
        System.out.println(pivotIndex);
        
        int leftResult = binarySearch(nums, 0, pivotIndex, target);

        return leftResult != -1 ? leftResult : binarySearch(nums, pivotIndex+1, nums.length-1, target);

        
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int findPivot(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;
            //System.out.println(nums[left] + ", " + nums[mid] + ", " + nums[right]);


            if (mid != nums.length-1 && nums[mid] > nums[mid+1])   {
                return mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        
        return left;
    }
}
