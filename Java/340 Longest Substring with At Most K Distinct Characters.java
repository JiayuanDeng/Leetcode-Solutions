import java.util.Hashtable;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return 0;
        int l = 0, r = 0;
        Hashtable<Character, Integer> ht = new Hashtable();
        ht.put(s.charAt(0), 1);
        int maxLen;
        
        // Move to first stable state
        while(true){
            r++;
            // Reach the end
            if(r >= s.length())
                return s.length();
            char c = s.charAt(r);
            if (ht.get(c) == null){
                // New char
                if (ht.size() < k){
                    ht.put(c, 1);
                }
                else{
                    r--;
                    break;
                }
            }
            else{
                // Old char
                ht.put(c, ht.get(c) + 1);
            }
        }
        maxLen = r - l + 1;
        
        while(r < s.length() - 1){
            // Move to next stable state
            while(true){
                char c = s.charAt(l);
                if (ht.get(c) == 1){
                    ht.remove(c);
                    l++;
                    break;
                }
                else{
                    ht.put(c, ht.get(c) - 1);
                    l++;
                }
            }
            
            while(true){
                r++;
                if(r >= s.length()){
                    // Reach the end
                    r--;
                    break;
                }
                char c = s.charAt(r);
                if (ht.get(c) == null){
                    // New char
                    if (ht.size() < k){
                        ht.put(c, 1);
                    }
                    else{
                        r--;
                        break;
                    }
                }
                else{
                    // Old char
                    ht.put(c, ht.get(c) + 1);
                }
            }
            
            maxLen = maxLen >= r - l + 1 ? maxLen : r - l + 1;
        }
        
        return maxLen;
    }
}