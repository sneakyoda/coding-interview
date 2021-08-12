package leetcode;

import java.util.HashSet;
import java.util.Set;

class SudokuSolver {
	public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }
    
    boolean solve(int i, int j, char[][] board) {
        if (i == 9 && j == 0) {
            return true;
        }
        int nextI = i + (j + 1) / 9;
        int nextJ = (j + 1) % 9;
        if (board[i][j] != '.') {
            return solve(nextI, nextJ, board);
        }
        for (int k = 1; k < 10; k++) {
            board[i][j] = (char) ('0' + k);
            if (isValidSudoku(board)) {
                if (solve(nextI, nextJ, board)) {
                    return true;
                }
            }
            board[i][j] = '.';
        }
        return false;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Checker coChecker = new Checker();
            Checker rowChecker = new Checker();
            Checker tubeChecker = new Checker();
            for (int j = 0; j < 9; j++) {
                coChecker.add(board[i][j]);
                rowChecker.add(board[j][i]);
                tubeChecker.add(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]);
            }
            if (!(coChecker.state && rowChecker.state && tubeChecker.state)) {
                return false;
            }
        }
        return true;
        
    }
    
    class Checker {
        
        Set<Character> set = new HashSet<>();
        boolean state = true;
        
        void add(char i) {
            if (i == '.') {
                return;
            }
            if (set.contains(i)) {
                state = false;
            }
            set.add(i);
        }
    }
}