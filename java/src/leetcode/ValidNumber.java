package leetcode;

class ValidNumber {
	public boolean isNumber(String s) {
        boolean signed = false;
        boolean eStarted = false;
        boolean eSigned = false;
        boolean dotted = false;
        boolean prehalfExisted = false;
        int count = 0;
        int afterECount = 0;
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (signed && !eStarted) {
                    return false;
                }
                if (eStarted) {
                    if (eSigned || afterECount != 0) {
                        return false;
                    }
                    eSigned = true;
                }
                signed = true;
                continue;
            }
            if (c >= '0' && c <= '9') {
                signed = true;
                if (!eStarted) {
                    count--;
                }
                afterECount++;
                continue;
            }
            if (c == '.') {
                signed = true;
                if (eStarted || dotted) {
                    return false;
                }
                if (count < 0) {
                    prehalfExisted = true;
                }
                count = 1;
                dotted = true;
                continue;
            }
            if (c == 'e' || c == 'E') {
                if (afterECount == 0) {
                    return false;
                }
                if (eStarted || !signed) {
                    return false;
                }
                afterECount = 0;
                eStarted = true;
                continue;
            }
            return false;
        }
        return afterECount > 0 && (prehalfExisted || count < 1);
    }
}