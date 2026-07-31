class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupMap = new HashMap<>();

        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);

            List<String> anagramStrings = groupMap.getOrDefault(sortedStr, new ArrayList<>());
            anagramStrings.add(str);
            groupMap.put(sortedStr, anagramStrings);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> value :  groupMap.values()) {
            result.add(value);
        }

        return result;
    }
}
