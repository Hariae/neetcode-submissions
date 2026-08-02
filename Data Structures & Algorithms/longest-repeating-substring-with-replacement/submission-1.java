class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0, result = 0;

        for(int r=0;r<s.length();r++) {

            char c = s.charAt(r);
            
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));

            int currWindowDiff = r - l + 1 - maxFreq;

            while (currWindowDiff > k) {
                // move left
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                l++;
                currWindowDiff = r - l + 1 - maxFreq;
            }

            result = Math.max(result, r - l + 1);

        }

        return result;
        
        
    }
}
