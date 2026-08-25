class Solution {

    /*
    
    abc, cab, cat, dog

    3#abc3#cab67#
    01234
    
    */

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            int len = str.length();
            sb.append(len + "#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();

        
        while (str.length() > 0) {
            int delimeterIndex = str.indexOf('#');
            int length = Integer.parseInt(str.substring(0, delimeterIndex));
            String stringPart = str.substring(delimeterIndex+1, delimeterIndex+1+length);
            strs.add(stringPart);
            str = str.substring(delimeterIndex+1+length);
        }

        return strs;
    }
}
