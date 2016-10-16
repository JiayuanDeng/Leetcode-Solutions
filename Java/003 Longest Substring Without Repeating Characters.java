import java.util.Hashtable;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        int strLen = s.length();
        Integer prevDupeIdx;
        int prevBreakIdx = -1;
        int maxLen = 0;
        for (int i = 0; i < strLen; i++){
            prevDupeIdx = ht.get(s.charAt(i));
            if (prevDupeIdx != null) prevBreakIdx = prevBreakIdx > prevDupeIdx? prevBreakIdx : prevDupeIdx;
            ht.put(s.charAt(i), i);
            maxLen = maxLen > i - prevBreakIdx? maxLen : i - prevBreakIdx;
        }
        return maxLen;
    }
}