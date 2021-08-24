package leetcode;

class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        res[0][0] = 1;
        int x = 0, y = 0;
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            int[] next = next(x, y, n, n);
            x = next[0];
            y = next[1];
        }
        return res;
    }
    
    int[] next(int x, int y, int height, int width) {
        int offset = Math.min(Math.min(Math.min(x, height - 1 -x), y), width - 1 - y);
        if (x == offset) {
            if (y != width - 1 - offset) {
                return new int[]{x, y + 1};
            } else {
                return new int[]{x + 1, y};
            }
        }
        if (y == width - 1 - offset) {
            if (x != height - 1 - offset) {
                return new int[]{x + 1, y};
            } else {
                return new int[]{x, y - 1};
            }
        }
        if (x == height - 1 - offset) {
            if (y != offset) {
                return new int[]{x, y - 1};
            } else {
                return new int[]{x - 1, y};
            }
        }
        if (y == offset) {
            if (x != offset + 1) {
                return new int[]{x - 1, y};
            } else {
                return new int[]{x, y + 1};
            }
        }
        return null;                   
    }
}