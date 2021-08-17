package leetcode;

class WildcardMatching {
	public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = -1; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char wildCur = p.charAt(j);
                if (i == -1) {
                     if (wildCur == '*') {
                        dp[0][j + 1] = dp[0][j];
                     }
                    continue;
                }
                if (wildCur == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (wildCur != '*') {
                    dp[i + 1][j + 1] = dp[i][j] && s.charAt(i) == wildCur;
                } else {
                    for (int k = i + 1; k >= 0; k--) {
                        if (dp[k][j]) {
                            dp[i + 1][j + 1] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}