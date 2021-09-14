package leetcode;

class WordSearch {
	public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean res = search(board, i, j, word, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
    int[][] diffs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    boolean search(char[][] board, int i, int j, String word, int index) {
        boolean result = false;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return result;
        }
        if (board[i][j] != word.charAt(index)) {
            return result;
        }
        if (index == word.length() - 1) {
            return true;
        }
        board[i][j] = '+';
        for (int[] diff : diffs) {
            result = result | search(board, i + diff[0], j + diff[1], word, index + 1);
        }
        board[i][j] = word.charAt(index);
        return result;
    }
}