package leetcode;

class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int mirror = 0;
        while (x >= mirror) {
            int digit = x % 10;
            mirror = mirror * 10 + digit;
            if (x == mirror || x / 10 == mirror) {
                return true;
            }
            x /= 10;
        }
        return false;
    }
}