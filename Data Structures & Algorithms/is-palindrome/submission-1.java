class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        
        s = s.replaceAll("[^A-Za-z0-9]", "");
        //System.out.println(s);
        char[] charArray = s.toCharArray();
        int left = 0, right = charArray.length-1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
