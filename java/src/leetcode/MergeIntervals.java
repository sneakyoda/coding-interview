package leetcode;

import java.util.Arrays;

class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int curIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[curIndex][1]) {
                intervals[curIndex][1] = Math.max(intervals[curIndex][1], intervals[i][1]);
            } else {
                intervals[++curIndex] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, curIndex + 1);
    }
}