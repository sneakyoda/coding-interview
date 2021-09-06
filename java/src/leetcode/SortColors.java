package leetcode;

class SortColors {
	public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 2;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }
        int index = 0;
        while (index < nums.length) {
            if (zero != 0) {
                nums[index++] =0;
                zero--;
                continue;
            }
            if (one != 0) {
                nums[index++] = 1;
                one--;
                continue;
            }
            if (two != 0) {
                nums[index++] = 2;
                two--;
                continue;
            }
        }
    }
}