package leetcode;

import java.util.Stack;

class SimplifyPath {
	public String simplifyPath(String path) {
        String[] splits = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : splits) {
            if (s == null || s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}