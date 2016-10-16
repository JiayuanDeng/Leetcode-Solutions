public class Solution {
    public int reverse(int x) {
        int symbol = x >= 0 ? -1 : 1;
        int tmp = symbol * x;
        int result = tmp % 10;
        while(tmp >= 10 || tmp <= -10){
            tmp = tmp / 10;
            if ((Integer.MIN_VALUE - tmp % 10) / 10 > result) return 0;
            result = 10 * result + tmp % 10;
        }
        return symbol * result;
    }
}