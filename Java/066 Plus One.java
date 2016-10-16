public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = 0; i < digits.length; i++){
            if (digits[i] != 9) break;
            else if (i == digits.length - 1){
                int[] ans = new int[digits.length + 1];
                ans[0] = 1;
                for (int j = 1; j < ans.length; j++) ans[j] = 0;
                return ans;
            }
        }
        
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            digits[i] += carry;
            if (digits[i] > 9){
                digits[i] = 0;
            }
            else{
                break;
            }
        }
        return digits;
    }
}