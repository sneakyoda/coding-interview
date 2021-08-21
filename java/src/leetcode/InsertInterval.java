package leetcode;

import java.util.Arrays;

class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int curIndex = -1;
        int j = 0;
        for (int i = 0; i < intervals.length + 1; i++) {
            int[] inserted = j < intervals.length && intervals[j][0] < newInterval[0] ? intervals[j] : newInterval;
            if (curIndex == -1 || inserted[0] > res[curIndex][1]) {
                res[++curIndex] = new int[]{inserted[0], inserted[1]};
            } else {
                res[curIndex][1] = Math.max(res[curIndex][1], inserted[1]);
            }
            if (inserted == newInterval) {
                newInterval[0] = Integer.MAX_VALUE;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(res, curIndex + 1);
    }
}