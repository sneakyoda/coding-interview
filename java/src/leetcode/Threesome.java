package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Threesome {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int initialVal = nums[i];
            twoSum(nums, i + 1, -initialVal, res);
        }
        return res;
    }
    
    void twoSum(int[] nums, int from, int val, List<List<Integer>> res) {
        int i = from, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == val) {
                res.add(Arrays.asList(nums[from - 1], nums[i], nums[j]));
            }
            if (nums[i] + nums[j] < val) {
                i++;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
            } else {
                j--;
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }
}