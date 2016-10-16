public class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) return s;
        
        String[] line = new String[numRows];
        for (int i = 0; i < numRows; i++) line[i] = "";
        
        int len = s.length();
        int pos = 0, dir = 1;
        for (int i = 0; i < len; i++){
            line[pos] += s.charAt(i);
            pos += dir;
            if (pos == numRows - 1 || pos == 0) dir = -dir;
        }
        
        String result = "";
        for (int i = 0; i < numRows; i++) result += line[i];
        
        return result;
    }
}