package leetcode;

class NextPermutation {
	public void nextPermutation(int[] nums) {
        int decreasingIndex = nums.length - 2;
        while (decreasingIndex >= 0 && nums[decreasingIndex] >= nums[decreasingIndex + 1]) {
            decreasingIndex--;
        }
        if (decreasingIndex != -1) {
            int decreasedValue = nums[decreasingIndex];
            int leastLargerIndexThanDecreased = decreasingIndex + 1;
            while (leastLargerIndexThanDecreased < nums.length && nums[leastLargerIndexThanDecreased] > decreasedValue) {
                leastLargerIndexThanDecreased++;
            }
            leastLargerIndexThanDecreased--;
            nums[decreasingIndex] = nums[leastLargerIndexThanDecreased];
            nums[leastLargerIndexThanDecreased] = decreasedValue;
        }
        int i = decreasingIndex + 1, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}