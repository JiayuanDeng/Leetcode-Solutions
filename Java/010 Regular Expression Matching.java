public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int i, j, sLen = s.length(), pLen = p.length();
        boolean[][] m = new boolean[sLen + 1][pLen + 1];
        m[0][0] = true;
        for (j = 0; j < pLen; j++){
            if (p.charAt(j) == '*' && p.charAt(j - 1) != '*') m[0][j + 1] = m[0][j - 1];
        }
        for (i = 0; i < sLen; i++){
            for (j = 0; j < pLen; j++){
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) m[i + 1][j + 1] = m[i][j];
                if (p.charAt(j) == '*' && p.charAt(j - 1) != '*'){
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)){
                        // Match 0 element: if i match j - 2, i match j
                        // Match 1 element: if i - 1 match j - 2, i match j
                        // Match n elements: if i - 1 match j, i match j
                        m[i + 1][j + 1] = m[i + 1][j - 1] || m[i][j - 1] || m[i][j + 1]; 
                    }
                    else{
                        // Match 0 element: if i match j - 2, i match j
                        m[i + 1][j + 1] = m[i + 1][j - 1];
                    }
                }
            }
        }
        return m[sLen][pLen];
    }
}