class Solution {


    /*
    
    [1, 2, 0, 1, 0]
        * 
    
    */
    public boolean canJump(int[] nums) {
        boolean[] greedy = new boolean[nums.length];
        greedy[nums.length-1] = true;
        for (int i=nums.length-2;i>=0;i--) {
            int steps = nums[i];
            int curr = i;
            
            while (steps > 0) {
                if ((curr + steps) >= nums.length-1 || greedy[curr + steps] == true) {
                    greedy[curr] = true;
                    //System.out.println(steps + " " + curr);
                    break;
                } else {
                    steps--;
                }
            }   
            //System.out.println(Arrays.toString(greedy));        
        }
        //System.out.println(Arrays.toString(greedy));
        return greedy[0]; 
    }
}
