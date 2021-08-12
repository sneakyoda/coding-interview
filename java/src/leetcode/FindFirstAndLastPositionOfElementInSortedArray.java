package leetcode;

class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
        return new int[]{
            search(nums, 0, nums.length, target, true),
            search(nums, 0, nums.length, target, false)
        };
    }
    
    int search(int[] nums, int begin, int end, int target, boolean first) {
        if (begin >= end - 1) {
            return begin != end && target == nums[begin] ? begin : -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] > target) {
            return search(nums, begin, mid, target, first);
        }
        if (nums[mid] < target) {
            return search(nums, mid + 1, end, target, first);
        }
        if (first) {
            if (mid == 0 || nums[mid] != nums[mid - 1]) {
                return mid;
            }
            return search(nums, begin, mid, target, first);
        } else {
            return search(nums, mid, end, target, first);
        }
    }
}