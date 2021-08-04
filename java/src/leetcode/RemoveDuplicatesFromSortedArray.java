package leetcode;

class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        if (nums.length == 0) {
            return 0;
        }
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }
}