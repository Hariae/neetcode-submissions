class Solution {

    // saving some efforts using maps
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<>();

        if (s.length() <= 1) return s.length();

        int left = 0, right = 0;
        int maxLength = 1;

        while (left < s.length() && right < s.length()) {
            if (!seen.containsKey(s.charAt(right))) {
                seen.put(s.charAt(right), right);
                
            } else {
                left = left < seen.get(s.charAt(right)) + 1 ? seen.get(s.charAt(right)) + 1 : left;
                 seen.put(s.charAt(right), right);     
                // seen.remove(s.charAt(left));
                //left++;
                
            }
           
            maxLength = Math.max(right-left + 1, maxLength);      
            right++;          

           // System.out.println(maxLength + " : " + seen);
        }

        return maxLength;
    }


    // public int lengthOfLongestSubstring(String s) {

    //     HashSet<Character> seen = new HashSet<>();

    //     if (s.length() <= 1) return s.length();

    //     int left = 0, right = 0;
    //     int maxLength = 1;

    //     while (left < s.length() && right < s.length()) {
    //         if (!seen.contains(s.charAt(right))) {
    //             seen.add(s.charAt(right));
    //             maxLength = Math.max(right-left + 1, maxLength);      
    //             right++;          
    //         } else {
    //             seen.remove(s.charAt(left));
    //             left++;
    //         }

    //       //  System.out.println(right + " : " + seen);
    //     }

    //     return maxLength;
        
    // }
}
