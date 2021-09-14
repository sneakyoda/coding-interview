package leetcode;

class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        int index = 0, cur = 0;
        while (cur < nums.length) {
            if (index - 2 >= 0 && nums[index - 2] == nums[cur]) {
                cur++;
            } else {
                nums[index++] = nums[cur++];
            }
        }
        return index;
    }
}