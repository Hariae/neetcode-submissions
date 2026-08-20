class Solution {

    /*
    
    tempminProd = Math.min(curr, math.min(max * curr, mnin * cuirr);
    maxProd = math.max(curr, math.max(max * curr, mnin * cuirr);
    res = math.max(max, res)
    minprod = tempminprod




    
    
    */

    public int maxProduct(int[] nums) {

        int maxProd = 1; int minProd = 1;
        int result = Integer.MIN_VALUE;

        for (int num : nums) {

            int tempMinProd = Math.min(num, Math.min(maxProd * num, minProd * num));
            maxProd = Math.max(num, Math.max(maxProd * num, minProd * num));
            minProd = tempMinProd;
            result = Math.max(result, maxProd);
        }

        return result;
        
    }
}
