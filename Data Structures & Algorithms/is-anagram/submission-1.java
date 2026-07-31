class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] countArray = new int[26];

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            countArray[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            
            if (countArray[c - 'a'] > 0) {
                countArray[c - 'a']--;                
            } else {
                return false;
            }
        }

        for (int i=0;i<26;i++) {
            if (countArray[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
