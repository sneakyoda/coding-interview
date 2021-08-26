package leetcode;

class ClimbingStairs {
	public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }
        int s1 = 2, s2 = 3;
        for (int i = 4; i <= n; i++) {
            int newSteps = s1 + s2;
            s1 = s2;
            s2 = newSteps;
        }
        return s2;
    }
}