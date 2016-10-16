public class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> ans =  new LinkedList<String>();
        addParenthesis("", ans, n, n);
        return ans;
    }
    
    /* 
     *  s: current formed string
     *  ans: container of answer strings
     *  left: number of unused left parenthesis
     *  right: number of unused right parenthesis
    */
    
    public void addParenthesis(String s, List<String> ans, int left, int right){
        // All right parenthesises are used. Reached the end of string.
        if (right == 0){
            ans.add(s);
        }
        
        // Left parenthesis available
        if (left > 0){
            addParenthesis(s + "(", ans, left - 1, right);
        }
        
        // Right parenthesis available
        if (right > left){
            addParenthesis(s + ")", ans, left, right - 1);
        }
    }
}