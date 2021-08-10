package leetcode;

class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i + 1] = dp[i - 1] + 2;
                }
                if (dp[i] != 0 && (i - dp[i] - 1 >= 0 && s.charAt(i - dp[i] - 1) == '(')) {
                    dp[i + 1] = dp[i] + 2 + dp[i - dp[i] - 1];
                }
                max = Math.max(max, dp[i + 1]);
            }
        }
        return max;
    }
}