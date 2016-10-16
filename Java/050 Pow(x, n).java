public class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long pow = n > 0 ? n : -(long)n;
        while(pow > 0) {
            if((pow & 1)==1) ans *= x;
            x *= x;
            pow >>= 1;
        }
        return n > 0 ? ans : 1 / ans;
    }
}