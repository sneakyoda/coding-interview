package leetcode;

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {

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