class Solution {
    public int[] countBits(int n) {
        
        int[] result = new int[n+1];

        for (int i=0;i<=n;i++) {
            int temp_n = i;
            int count = 0;
            while (temp_n > 0) {
                if ((temp_n&1) != 0) {
                    count++;
                }
                
                temp_n = temp_n >> 1;
            }

            result[i] = count;

        }

        return result;
    }

    
}
