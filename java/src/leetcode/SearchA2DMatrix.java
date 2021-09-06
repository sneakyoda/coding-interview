package leetcode;

import java.util.Arrays;

class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int i = -1, j = matrix.length;
        while (i < j - 1) {
            int mid = (i + j) / 2;
            if (matrix[mid][0] > target) {
                j = mid;
            } else if (matrix[mid][0] < target) {
                i = mid;
            } else {
                return true;
            }
        }
        if (i == -1) {
            return false;
        }
        return Arrays.binarySearch(matrix[i], target) >= 0;
    }
}