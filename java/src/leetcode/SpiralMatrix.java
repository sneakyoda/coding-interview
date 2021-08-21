package leetcode;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        List<Integer> res = new ArrayList<>(height * width);
        res.add(matrix[0][0]);
        int x = 0, y = 0;
        for (int i = 0; i < height * width - 1; i++) {
            int[] pos = next(x, y, height, width);
            res.add(matrix[pos[0]][pos[1]]);
            x = pos[0];
            y = pos[1];
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