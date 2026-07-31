class Solution {
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) == 0) {
                    freqMap.remove(c);
                }
            } else {
                return false;
            }
        }

        return freqMap.size() == 0;

    }
}
