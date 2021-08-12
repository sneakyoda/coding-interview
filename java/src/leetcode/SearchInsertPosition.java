package leetcode;

class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        int begin = -1, end = nums.length;
        while (begin < end - 1) {
            int mid = (begin + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        return end;
    }
}