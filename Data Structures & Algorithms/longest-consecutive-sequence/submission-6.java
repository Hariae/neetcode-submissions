class Solution {
    // public int longestConsecutive(int[] nums) {
    //     HashMap<Integer, Integer> seqMap = new HashMap<>();
    //         int max = 0;
    //     for(int num : nums) {
    //         if (!seqMap.containsKey(num)) {

    //             int newCount = 
    //         seqMap.getOrDefault(num-1, 0) + 
    //         seqMap.getOrDefault(num+1, 0) + 
    //         1;


    //         // update for num
    //         seqMap.put(num, newCount);

    //         seqMap.put(num - seqMap.getOrDefault(num-1, 0), newCount);
    //         seqMap.put(num + seqMap.getOrDefault(num+1, 0), newCount);


            

            
    //         max = Math.max(max, newCount);
    //         //System.out.println(num + " : " + seqMap + " : " + max);    
    //         } 



    //         // find pre-num
            
            

            
            
    //     }

    //     // //System.out.println(seqMap);
    //     // int max = 0;
    //     // for(int value : seqMap.values()) {
    //     //     max = value > max ? value : max;
    //     // }
    //     return max;
    // }


    // hashset approach


     public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
            
        }

        int longest = 0;

        for (int num : nums) {
            int streak = 0;
            if (!set.contains(num-1)) {
                streak++;
                int currNum = num+1;
                while(set.contains(currNum)) {
                    streak++;
                    currNum++;
                }
                longest = Math.max(longest, streak);
            }
        }

        return longest;
     }
}
