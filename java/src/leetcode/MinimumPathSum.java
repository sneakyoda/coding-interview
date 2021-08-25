package leetcode;

class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i][j] = Math.min(i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE, j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE) + grid[i][j];
            }
        }
        return dp[height - 1][width - 1];
    }
}