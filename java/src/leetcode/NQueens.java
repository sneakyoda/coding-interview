package leetcode;

import java.util.ArrayList;
import java.util.List;

class NQueens {
	char[][] board;
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, n);
        return res;
    }
    
    void dfs(int index, int n) {
        if (index == n) {
            res.add(persistSolution());
            return;
        }
        for (int i = 0; i < n; i++) {
            board[index][i] = 'Q';
            if (!conflicted()) {
                dfs(index + 1, n);
            }
            board[index][i] = '.';
        }
    }
    
    List<String> persistSolution() {
        List<String> li = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
            li.add(sb.toString());
        }
        return li;
    }
    
    boolean conflicted(int i, int j, int[] diff) {
        int counter = 0;
        while (i >= 0 && j >= 0 && i < board.length && j < board.length) {
            if (board[i][j] == 'Q') {
                if (counter == 1) {
                    return true;
                }
                counter++;
            }
            i += diff[0];
            j += diff[1];
        }
        return false;
    }
    
    boolean conflicted(int i, int j, int[][] diffs) {
        for (int[] diff : diffs) {
            if (conflicted(i, j, diff)) {
                return true;
            }
        }
        return false;
    }
    
    boolean conflicted() {
        for (int i = 0; i < board.length; i++) {
            if (conflicted(0, i, new int[][]{{1, 0}, {1, -1}, {1, 1}})) {
                return true;
            }
            if (conflicted(i, 0, new int[][]{{0, 1}, {-1, 1}, {1, 1}})) {
                return true;
            }
            if (conflicted(i, board.length - 1, new int[]{1, -1})) {
                return true;
            }
        }
        return false;        
    }
}