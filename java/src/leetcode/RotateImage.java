package leetcode;

class RotateImage {
	public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix[i].length - 1 - j][matrix.length - 1 - i];
                matrix[matrix[i].length - 1 - j][matrix.length - 1 - i] = tmp;
            }
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = tmp;
            }
        }
    }
}