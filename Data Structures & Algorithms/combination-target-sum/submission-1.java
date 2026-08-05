class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        Arrays.sort(nums);

        

        dfs(nums, new ArrayList(), target);
        //System.out.println(result);
        return new ArrayList<>(result);
    }

    

    public void dfs(int[] nums, List<Integer> currPath, int target) {
       
      //  System.out.println(currPath);
        int sum = 0;
        for (int num : currPath) {
            sum += num;
        }

        if (sum == target) {
                        
           // System.out.println("Found : " + currPath);
            List<Integer> sortedPath = new ArrayList<>(currPath);
            sortedPath.sort(Comparator.naturalOrder());
            result.add(sortedPath);            
        } else {
            for (int i=0;i<nums.length;i++) {
                if (sum + nums[i] <= target) {
                    currPath.add(nums[i]);
                    dfs(nums, currPath, target);
                } 
            }
        }
        
        
        

        if (currPath.size() > 0) {
            currPath.remove(currPath.size() - 1);
        }
        
        return;
    }
}
