class PowXn {
	public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n / 2 * 2 == n) {
            double res = myPow(x, n / 2);
            return res * res;
        } else {
            return myPow(x, n / 2) * myPow(x, n - n / 2);
        }
    }
}