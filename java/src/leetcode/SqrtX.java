package leetcode;

class SqrtX {
	public int mySqrt(int x) {
        long begin = 0, end = x;
        if (x < 2) {
            return x;
        }
        while (begin < end - 1) {
            long mid = (begin + end) / 2;
            if (mid * mid > x) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        return (int) begin;
    }
}