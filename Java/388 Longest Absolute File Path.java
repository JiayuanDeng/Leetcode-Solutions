public class Solution {
    public class Node{
        public int len;
        public int level;
        public Node(int l, int lv){len = l; level = lv;}
    }
    
    public int lengthLongestPath(String input) {
        Stack<Node> stack = new Stack<Node>();
        int maxLen = 0;
        
        for (String s : input.split("\n")){
            // Find the level and length of node "n"
            Node n = new Node(0, 0);
            if (s.contains("\t")){
                n.level = s.lastIndexOf("\t") + 1;
                n.len = s.length() - n.level;
            }
            else{
                n.level = 0;
                n.len = s.length();
            }
            
            // Remove all nodes that is not parent of node "n" in the stack
            while (!stack.empty() && stack.peek().level >= n.level){
                stack.pop();
            }
            
            // Update the length of node "n"
            if (!stack.empty()){
                n.len += stack.peek().len + 1;
            }
            
            // If node "n" is a file, update maxLen
            if (s.contains(".")){
                maxLen = n.len > maxLen ? n.len : maxLen;
            }
            
            // Puch node "n" into the stack 
            stack.push(n);
        }
        
        return maxLen;
    }
}