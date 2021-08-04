package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {
	Map<Character, Character> reverseMap = new HashMap<>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch(ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (!verifyAndPop(stack, reverseMap.get(ch))) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
    
    private boolean verifyAndPop(Stack<Character> stack, char target) {
        if (stack.isEmpty() || stack.peek() != target) {
            return false;
        }
        stack.pop();
        return true;
    }
}