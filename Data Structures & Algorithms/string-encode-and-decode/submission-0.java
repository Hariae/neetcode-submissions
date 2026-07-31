class Solution {

    public String encode(List<String> strs) {
        
        String delimiter = "#";

        StringBuilder encodedString = new StringBuilder();



        for(String str : strs) {
            
            encodedString.append(str.length());
            encodedString.append(delimiter);
            encodedString.append(str);
        }



        return encodedString.toString();
    }

    public List<String> decode(String str) {

        List<String> decodedStrings = new ArrayList<>();
        int i=0,j=0;
        while (i<str.length()) {
            while(j<str.length() && str.charAt(j) != '#') {                
                j++;                
            }

            int length = Integer.parseInt(str.substring(i, j));
            // "4#look2#is"
            //.    2345  
            String decodedString = str.substring(j+1, j+1+length);
            decodedStrings.add(decodedString);

            j = j+1+length;
            i = j;
        }

        return decodedStrings;
        
    }
}
