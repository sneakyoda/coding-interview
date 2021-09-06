package leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    cols.add(i);
                    rows.add(j);
                }
            }
        }
        for (Integer col : cols) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[col][j] = 0;
            }
        }
        for (Integer row : rows) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][row] = 0;
            }
        }
    }
}