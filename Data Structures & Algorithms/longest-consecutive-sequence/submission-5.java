class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> seqMap = new HashMap<>();
            int max = 0;
        for(int num : nums) {
            if (!seqMap.containsKey(num)) {

                int newCount = 
            seqMap.getOrDefault(num-1, 0) + 
            seqMap.getOrDefault(num+1, 0) + 
            1;


            // update for num
            seqMap.put(num, newCount);

            seqMap.put(num - seqMap.getOrDefault(num-1, 0), newCount);
            seqMap.put(num + seqMap.getOrDefault(num+1, 0), newCount);


            

            
            max = Math.max(max, newCount);
            //System.out.println(num + " : " + seqMap + " : " + max);    
            } 



            // find pre-num
            
            

            
            
        }

        // //System.out.println(seqMap);
        // int max = 0;
        // for(int value : seqMap.values()) {
        //     max = value > max ? value : max;
        // }
        return max;
    }
}
