class Solution {
    
    public List<List<Integer>> twoSum(int[] nums, int index, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i=index;i<nums.length;i++) {
            if (map.containsKey(target - nums[i]) && 
            map.get(target-nums[i]) != i) {
                // found a match
                List<Integer> resultItem = new ArrayList<>();        

                resultItem.add(nums[i]);
                resultItem.add(target-nums[i]);
                resultItem.add(target * -1);
                Collections.sort(resultItem);
                result.add(resultItem);
            }

            map.put(nums[i], i);
        }

        return result;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {

        HashSet<List<Integer>> resultSet = new HashSet<>();
        List<List<Integer>> resultList = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++) {
            List<List<Integer>> tempResults = twoSum(nums, i + 1, nums[i] * -1);

            for(List<Integer> tempResult : tempResults) {
                if (!resultSet.contains(tempResult)) {
                    resultList.add(tempResult);
                    resultSet.add(tempResult);
                }
            }
            
        }

        return resultList;
       
    }
}
