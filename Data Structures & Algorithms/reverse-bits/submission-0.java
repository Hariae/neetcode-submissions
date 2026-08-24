class Solution {
    public int reverseBits(int n) {
          int ret = 0, power = 31;
        while (n != 0) {
            ret = ret + ((n & 1) << power);
            n = n >>> 1;
            power--;
        }

        return ret;
    }
}
