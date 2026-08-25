class Solution {

    /*
    
        [1, 2, 4, 6]
        
        currprod = 2
        prev = 4
        
        [1, 1, 2, 8]

        currprod = 24;
        prev = 2
        
        [48, 24, 12, 8]


    */

    public int[] productExceptSelf(int[] nums) {
        

        int currProd = 1, prev = 1;
        int[] result = new int[nums.length];

        // forward prod
        for (int i=0;i<nums.length;i++) {
            result[i] = currProd * prev;
            currProd = currProd * prev;
            prev = nums[i];
        }

        //backward prod
        currProd = 1; prev = 1;
        for (int i=nums.length-1;i>=0;i--) {
            result[i] = result[i] * currProd * prev;
            currProd = currProd * prev;
            prev = nums[i];
        }

        return result;


    }
}  
