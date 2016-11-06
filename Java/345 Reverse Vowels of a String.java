public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while(l < r){
            if (!isVowel(chars[l])) l++;
            if (!isVowel(chars[r])) r--;
            if (isVowel(chars[l]) && isVowel(chars[r])){
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
    
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        else return false;
    }
}