public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++){
            dp[i] = i;          // The worst case: n of 1
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                if(dp[i] > dp[i - j * j] + 1) dp[i] = dp[i - j * j] + 1;
            }
        }
        return dp[n];
    }
}