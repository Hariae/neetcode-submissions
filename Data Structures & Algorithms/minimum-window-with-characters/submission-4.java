class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> windowMap = new HashMap<>();

        int l = 0, have = 0, need = tMap.size(), min = Integer.MAX_VALUE;
        int[] resultIndex = new int[2];
        //String result = "";

        for (int r=0; r<s.length(); r++) {
            char c = s.charAt(r);

            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && tMap.get(c) == windowMap.get(c)) {
                have++;
            }

            while (have == need) {
                // found a match
                int len = r - l + 1;
                if (len < min) {
                    min = len;
                    resultIndex[0] = l;
                    resultIndex[1] = r;     
                    //result = s.substring(l, r + 1);
                }

                char leftChar = s.charAt(l);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                l++;
            }

        }

        return min == Integer.MAX_VALUE ? "" : s.substring(resultIndex[0], resultIndex[1] + 1);
    }
}
