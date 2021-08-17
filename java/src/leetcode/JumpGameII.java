package leetcode;

class JumpGameII {
	public int jump(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            for (int j = i + 1; j < nums.length && j <= i + val; j++) {
                if (res[j] == 0) {
                    res[j] = Integer.MAX_VALUE;
                }
                res[j] = Math.min(res[j], res[i] + 1);
            }
        }
        return res[res.length - 1];
    }
}