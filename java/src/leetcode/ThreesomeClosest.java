class ThreesomeClosest {
	public int threeSumClosest(int[] nums, int target) {
        int cur = 10000000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int twoTarget = target - nums[i];
            int from = i + 1, to = nums.length - 1;
            while (from < to) {
                cur = Math.abs(cur - target) > Math.abs(twoTarget - nums[from] - nums[to]) ? nums[i] + nums[from] + nums[to] : cur;
                if (nums[from] + nums[to] > twoTarget) {
                    to--;
                } else if (nums[from] + nums[to] < twoTarget) {
                    from++;
                } else {
                    return target;
                }
            } 
        }
        return cur;       
    }
}