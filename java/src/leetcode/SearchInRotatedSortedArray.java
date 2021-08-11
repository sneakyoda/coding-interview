package leetcode;

class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);    
    }
    
    private int search(int[] nums, int begin, int end, int target) {
        if (begin == end) {
            return -1;
        }
        if (begin == end - 1) {
            return nums[begin] == target ? begin : -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[begin] == target) {
            return begin;
        }
        if (nums[end - 1] == target) {
            return end - 1;
        }
        if (nums[mid] < nums[begin] && nums[mid] < nums[end - 1]) {
            if (nums[mid] > target) {
               return search(nums, begin, mid, target);
            } else if (nums[end - 1] > target) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, begin, mid, target);
            }
        }
        if (nums[mid] > nums[begin] && nums[mid] > nums[end - 1]) {
            if (nums[mid] < target) {
               return search(nums, mid + 1, end, target);
            } else if (nums[begin] > target) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, begin, mid, target);
            }
        }
        if (nums[mid] > target) {
            return search(nums, begin, mid, target);
        } else {
            return search(nums, mid + 1, end, target);
        }
    }
}