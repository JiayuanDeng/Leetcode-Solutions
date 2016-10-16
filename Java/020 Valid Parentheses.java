public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)){
			    case '(':
			        stack.push('(');
			        break;
			    case '{':
			        stack.push('{');
			        break;
			    case '[':
			        stack.push('[');
			        break;
			    case ')':
			        if(stack.empty()) return false;
			        if(stack.pop() != '(') return false;
			        break;
			    case '}':
			        if(stack.empty()) return false;
			        if(stack.pop() != '{') return false;
			        break;
			    case ']':
			        if(stack.empty()) return false;
			        if(stack.pop() != '[') return false;
			        break;
			    default:
			        break;
			}
		}
		if (stack.empty())
		    return true;
		else
		    return false;
    }
}