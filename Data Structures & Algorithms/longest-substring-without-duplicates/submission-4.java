class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> seen = new HashSet<>();

        if (s.length() <= 1) return s.length();

        int left = 0, right = 0;
        int maxLength = 1;

        while (left < s.length() && right < s.length()) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                maxLength = Math.max(right-left + 1, maxLength);      
                right++;          
            } else {
                seen.remove(s.charAt(left));
                left++;
            }

          //  System.out.println(right + " : " + seen);
        }

        return maxLength;
        
    }
}
