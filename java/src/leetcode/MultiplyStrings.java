package leetcode;

class MultiplyStrings {
	public String multiply(String num1, String num2) {
        String res = "0";
        for (int i = 0; i < num2.length(); i++) {
            char digit = num2.charAt(num2.length() - 1 - i);
            res = multiAdd(res, singleDigitMultiply(num1, digit, i));
        }
        return res;
    }
    
    String multiAdd(String num1, String num2) {
        int remains = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int digit1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int digit2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            remains += digit1 + digit2;
            sb.insert(0, remains % 10);
            remains /= 10;
        }
        if (remains != 0) {
            sb.insert(0, remains);
        }
        return sb.toString();
    }
    
    String singleDigitMultiply(String number, char digit, int tenxer) {
        int remains = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            char op = number.charAt(i);
            remains += (op - '0') * (digit - '0');
            sb.insert(0, remains % 10);
            remains /= 10;
        }
        if (remains != 0) {
            sb.insert(0, remains);
        }
        if (digit == '0' || sb.toString().equals("0")) {
            return "0";
        }
        for (int i = 0; i < tenxer; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}