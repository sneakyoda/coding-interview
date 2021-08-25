package leetcode;

class PlusOne {
	public int[] plusOne(int[] digits) {
        int added = 1;
        int i = digits.length - 1;
        while (i >= 0 && added != 0) {
            digits[i] += added;
            if (digits[i] == 10) {
                added = 1;
                digits[i] = 0;
            } else {
                added = 0;
            }
            i--;
        }
        int[] res = new int[digits.length + added];
        for (int j = digits.length - 1 + added; j >= 0; j--) {
            if (added == 1 && j == 0) {
                res[j] = 1;
                break;
            }
            res[j] = digits[j - added];
        }
        return res;
    }
}