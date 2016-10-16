public class Solution {
    public String longestPalindrome(String s) {
        String cur = "";
        int len = s.length();
        int center, range;
        for (center = 0; center < len; center++){
            for (range = 0; range < len; range ++){
                if (center - range < 0 || center + range >= len) break;
                if (s.charAt(center - range) != s.charAt(center + range))break;
            }
            range -= 1;
            if (2 * range + 1 > cur.length()){
                cur = s.substring(center - range, center + range + 1);
            }
            
            for (range = 0; range < len; range ++){
                if (center - range < 0 || center + range + 1 >= len) break;
                if (s.charAt(center - range) != s.charAt(center + range + 1)) break;
            }
            range -= 1;
            if (2 * range + 2 > cur.length()){
                cur = s.substring(center - range, center + range + 2);
            }
        }
        return cur;
    }
}