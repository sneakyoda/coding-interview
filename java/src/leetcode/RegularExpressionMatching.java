package leetcode;

class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        int starIndex = 1;
        while (starIndex < p.length() && p.charAt(starIndex) == '*') {
            dp[0][starIndex + 1] = true;
            starIndex += 2;
        }
        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (charMatch(s.charAt(j), p.charAt(i))) {
                    dp[j + 1][i + 1] = dp[j][i];
                }
                if (p.charAt(i) == '*') {
                    dp[j + 1][i + 1] = dp[j + 1][i - 1] || dp[j + 1][i] || (dp[j][i + 1] &&  charMatch(s.charAt(j), p.charAt(i - 1)));
                }
            }
        }
        return dp[s.length()][p.length()];
        
    }
    
    private boolean charMatch(char a, char b) {
        return a == b || b == '.';
    }

}