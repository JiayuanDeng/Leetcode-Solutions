public class Solution {
    public int climbStairs(int n) {
        // s[n] = s[n-1] + s[n-2]
        if (n < 3) return n;
        int f1 = 1, f2 = 1, f3 = 2;
        for(int i = 2; i < n; i++){
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return f3;
    }
}