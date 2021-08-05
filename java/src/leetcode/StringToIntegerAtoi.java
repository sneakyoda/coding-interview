package leetcode;

class StringToIntegerAtoi {
	public int myAtoi(String s) {
        int res = 0;
        int i  = 0;
        int sign = 1;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return res;
        }
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = (int) (s.charAt(i) - '0');
            if (sign == 1 && ((res == Integer.MAX_VALUE / 10 && digit >= 7) || (res > Integer.MAX_VALUE / 10))) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && ((res == Integer.MAX_VALUE / 10 && digit >= 8) || (res > Integer.MAX_VALUE / 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return res * sign;
    }
}