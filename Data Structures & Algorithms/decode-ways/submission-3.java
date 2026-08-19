class Solution {
    public int numDecodings(String s) {

        /*
        
        [1, 1, 1, 2, 1, 0, 0]

        "1012056"

        "10, 1,20"
        "11120"
        "1, 11, 20"
        "11, 1, 20"
        ""



        c -> 0, p -> 10
        
        */

        if (s.length() < 1) return s.length();
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i=2;i<=s.length();i++) {
            
            int curr = Integer.parseInt(s.charAt(i-1) + "");
            if (curr != 0) {
                dp[i] = dp[i - 1];
            }
 
            int prev = i == 0 ? 0 : Integer.parseInt(s.charAt(i-2)+""+ s.charAt(i-1));
           
            if (prev > 9 && prev <= 26) {
                dp[i] = dp[i-2] + dp[i];
            }  
            // if ( i > 0) {
            //     System.out.println(s.charAt(i-1) + " " + s.charAt(i) + " " + Integer.parseInt(s.charAt(i-i)+""+ s.charAt(i))+ " "+ dp[i] + " " + prev);
            // }
            

           
        }

        return dp[s.length()];
    }



   
}
