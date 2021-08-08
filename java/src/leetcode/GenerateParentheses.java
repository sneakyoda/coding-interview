package leetcode;

class GenerateParentheses {
	List<String> result;
    StringBuilder sb;
    
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        sb = new StringBuilder();
        dfs(n, n);
        return result;
    }
    
    private void dfs(int leftBudget, int rightBudget) {
        if (leftBudget == 0 && rightBudget == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftBudget != 0) {
            sb.append('(');
            dfs(leftBudget - 1, rightBudget);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (leftBudget == rightBudget) {
            return;
        }
        sb.append(')');
        dfs(leftBudget, rightBudget - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}